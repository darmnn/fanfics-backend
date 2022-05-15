package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
                                      @RequestParam(required = false) Long user,
                                      @RequestParam(required = false) Long tag);

    @PostMapping("/{id}/like")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void like(@PathVariable Long id);

    @PostMapping("/{id}/dislike")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void dislike(@PathVariable Long id);
}
