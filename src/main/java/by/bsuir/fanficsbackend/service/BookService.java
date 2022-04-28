package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/books")
public interface BookService extends CrudService<BookCreateRequestDTO, BookSearchDTO, BookUpdateRequestDTO, BookResponseDTO> {
    @GetMapping("/recent")
    @ResponseBody
    List<BookResponseDTO> getRecentWorks();
}
