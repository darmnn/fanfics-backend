package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequestMapping("/books")
public interface BookService extends CrudService<BookCreateRequestDTO, BookSearchDTO, BookUpdateRequestDTO, BookResponseDTO> {
    @GetMapping("/recent")
    @ResponseBody
    List<BookResponseDTO> getRecentWorks();

    @GetMapping("/search")
    @ResponseBody
    List<BookResponseDTO> search(@RequestParam(required = false) Long fandom,
                                      @RequestParam(required = false) Long category,
                                      @RequestParam(required = false) Long genre,
                                      @RequestParam(required = false) Long user);
}
