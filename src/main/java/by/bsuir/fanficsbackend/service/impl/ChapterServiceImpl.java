package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.exception.ResourceNotFoundException;
import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.persistence.entity.Chapter;
import by.bsuir.fanficsbackend.persistence.entity.User;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.persistence.repository.ChapterRepository;
import by.bsuir.fanficsbackend.persistence.repository.UserRepository;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.ChapterService;
import by.bsuir.fanficsbackend.service.assembler.ChapterRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.ChapterResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.ChapterCreateRequestDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterResponseDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterSearchDTO;
import by.bsuir.fanficsbackend.service.dto.ChapterUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ChapterServiceImpl extends AbstractCrudService<ChapterResponseDTO, ChapterCreateRequestDTO,
        ChapterUpdateRequestDTO, ChapterSearchDTO, Chapter, ChapterRepository> implements ChapterService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    public ChapterServiceImpl(ChapterResponseDTOAssembler responseAssembler, ChapterRequestDTOAssembler requestAssembler) {
        super(responseAssembler, requestAssembler, Chapter.class);
    }

    @Override
    public List<ChapterResponseDTO> getBookChapters(Long id) {
        List<Chapter> entities = new ArrayList<>();
        entities.addAll(repository.findByBookId(id));
        return entities.stream().map(e -> responseAssembler.toModel(e)).collect(Collectors.toList());
    }

    @Override
    protected void processAdditionalFieldForCreate(ChapterCreateRequestDTO dto, Chapter entity) {
        List<Chapter> bookChapters = repository.findByBookId(entity.getBook().getId());
        entity.setNumber(bookChapters.size());
        repository.save(entity);
    }

    @Override
    public ChapterResponseDTO patch(Long id, ChapterUpdateRequestDTO dto) throws HttpRequestMethodNotSupportedException {
        Chapter entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No chapter with ID " +
                id.toString()));

        if (dto.getText() != null) {
            entity.setText(dto.getText());
        }
        if (dto.getName() != null) {
            entity.setName(dto.getName());
        }

        repository.save(entity);

        return responseAssembler.toModel(entity);
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();

            User user = userRepository.findByName(currentUserName);
            Book book = repository.findById(id).orElseThrow().getBook();

            return book.getUser().equals(user);
        } else {
            return false;
        }
    }
}
