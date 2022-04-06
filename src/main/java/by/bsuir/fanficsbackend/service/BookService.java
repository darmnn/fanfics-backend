package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.BookResponseDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/books")
public interface BookService extends ReadService<BookResponseDTO, SearchDTO> {
    @GetMapping("/recent")
    @ResponseBody
    List<BookResponseDTO> getRecentWorks();
}
