package by.bsuir.fanficsbackend.service.validation;

import by.bsuir.fanficsbackend.persistence.entity.AbstractEntity;
import by.bsuir.fanficsbackend.persistence.repository.*;
import by.bsuir.fanficsbackend.service.dto.BookCreateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
public class BookValidator implements RestValidator {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private FandomRepository fandomRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public void validate(Object obj, AbstractEntity entity, Errors errors) {
        BookCreateRequestDTO dto = (BookCreateRequestDTO) obj;

        if (dto.getCategoryId() == null || dto.getFandomId() == null || dto.getGenreId() == null || dto.getName() == null
                || dto.getName().isEmpty()) {
            errors.reject("You must fill in book name, category, fandom and genre to create new book.");
            return;
        }

        if (!categoryRepository.findById(dto.getCategoryId()).isPresent()) {
            errors.reject("This category doesn't exist.");
        }

        if (!fandomRepository.findById(dto.getFandomId()).isPresent()) {
            errors.reject("This fandom doesn't exist.");
        }

        if (!genreRepository.findById(dto.getGenreId()).isPresent()) {
            errors.reject("This genre doesn't exist.");
        }

        if (!userRepository.findById(dto.getUserId()).isPresent()) {
            errors.reject("This user doesn't exist.");
        }

        if (dto.getTagIds() != null) {
            for (Long tagId : dto.getTagIds()) {
                if (!tagRepository.existsById(tagId)) {
                    errors.reject("One of the tags doesn't exist, ID : " + tagId.toString() + " .");
                }
            }
        }
    }

    @Override
    public Class<?> supports() {
        return BookCreateRequestDTO.class;
    }
}
