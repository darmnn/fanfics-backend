package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.RequestDTO;
import by.bsuir.fanficsbackend.service.dto.ResponseDTO;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

@Validated
public interface CrudService<C extends RequestDTO, S extends SearchDTO, U extends RequestDTO, R extends ResponseDTO>
        extends ReadService<R, S> {
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin(origins = "http://localhost:3000")
    R create(@RequestBody C dto, BindingResult bindingResult) throws HttpRequestMethodNotSupportedException;

    @PatchMapping("/{id}")
    @ResponseBody
    @PreAuthorize("this.hasUpdateAccess(#id)")
    R patch(@PathVariable Long id, @RequestBody U dto) throws HttpRequestMethodNotSupportedException;

    @DeleteMapping("/{id}")
    @Validated
    void delete(@PathVariable Long id);

    default boolean hasUpdateAccess(Long id) {
        return false;
    }
}
