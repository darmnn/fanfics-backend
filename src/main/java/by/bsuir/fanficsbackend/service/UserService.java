package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.UserRequestDTO;
import by.bsuir.fanficsbackend.service.dto.UserResponseDTO;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
public interface UserService extends CrudService<UserRequestDTO, SearchDTO, UserRequestDTO, UserResponseDTO> {
}
