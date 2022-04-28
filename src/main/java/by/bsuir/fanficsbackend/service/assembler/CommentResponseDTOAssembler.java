package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.Comment;
import by.bsuir.fanficsbackend.service.dto.CommentResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class CommentResponseDTOAssembler extends AbstractResponseDTOAssembler<Comment, CommentResponseDTO> {
    public CommentResponseDTOAssembler(){
        super(CommentResponseDTO.class, Comment.class);
    }
}
