package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Validated
public interface ReadService<R extends ResponseDTO, S extends SearchDTO> {
    @GetMapping
    @ResponseBody
    List<R> search(S dto);

    @GetMapping("/{id}")
    @ResponseBody
    R get(@PathVariable Long id);
}
