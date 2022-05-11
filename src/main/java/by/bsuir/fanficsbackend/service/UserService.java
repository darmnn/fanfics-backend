package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.UserRequestDTO;
import by.bsuir.fanficsbackend.service.dto.UserResponseDTO;
import by.bsuir.fanficsbackend.service.dto.UserSearchDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/users")
public interface UserService extends CrudService<UserRequestDTO, UserSearchDTO, UserRequestDTO, UserResponseDTO> {
    @PostMapping("/{id}/block")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void block(@PathVariable Long id);

    @PostMapping("/{id}/unlock")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void unlock(@PathVariable Long id);
}
