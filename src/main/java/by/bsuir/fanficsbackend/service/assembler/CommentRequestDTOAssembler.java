package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Book;
import by.bsuir.fanficsbackend.persistence.entity.Comment;
import by.bsuir.fanficsbackend.persistence.entity.User;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.persistence.repository.UserRepository;
import by.bsuir.fanficsbackend.service.dto.CommentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentRequestDTOAssembler extends AbstractRequestDTOAssembler<Comment, CommentRequestDTO, CommentRequestDTO> {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public CommentRequestDTOAssembler() {
        super(Comment.class, CommentRequestDTO.class, CommentRequestDTO.class);
    }

    @Override
    protected void populateAdditionalFieldsForCreate(Comment entity, CommentRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow();
        Book book = bookRepository.findById(dto.getBookId()).orElseThrow();

        entity.setBook(book);
        entity.setUser(user);
    }
}
