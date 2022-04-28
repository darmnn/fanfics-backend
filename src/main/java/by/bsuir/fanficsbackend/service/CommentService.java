package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.CommentRequestDTO;
import by.bsuir.fanficsbackend.service.dto.CommentResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/comments")
public interface CommentService extends CrudService<CommentRequestDTO, SearchDTO, CommentRequestDTO, CommentResponseDTO> {
    @GetMapping("/book/{id}")
    @ResponseBody
    List<CommentResponseDTO> getBookComments(@PathVariable Long id);
}
