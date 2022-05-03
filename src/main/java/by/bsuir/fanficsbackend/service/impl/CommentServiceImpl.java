package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.Comment;
import by.bsuir.fanficsbackend.persistence.repository.BookRepository;
import by.bsuir.fanficsbackend.persistence.repository.CommentRepository;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.CommentService;
import by.bsuir.fanficsbackend.service.assembler.CommentRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.CommentResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.CommentRequestDTO;
import by.bsuir.fanficsbackend.service.dto.CommentResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CommentServiceImpl extends AbstractCrudService<CommentResponseDTO, CommentRequestDTO, CommentRequestDTO,
        SearchDTO, Comment, CommentRepository> implements CommentService {
    @Autowired
    private CommentResponseDTOAssembler responseAssembler;

    @Autowired
    private CommentRepository repository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    public CommentServiceImpl(CommentResponseDTOAssembler responseAssembler, CommentRequestDTOAssembler requestAssembler) {
        super(responseAssembler, requestAssembler, Comment.class);
    }

    @Override
    public List<CommentResponseDTO> getBookComments(Long id) {
        List<Comment> entities = new ArrayList<>();
        entities.addAll(repository.findByBookId(id));
        return entities.stream().map(e -> responseAssembler.toModel(e)).collect(Collectors.toList());
    }

    @Override
    protected void processAdditionalFieldForCreate(CommentRequestDTO dto, Comment entity) {
        super.processAdditionalFieldForCreate(dto, entity);
    }
}
