package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.User;
import by.bsuir.fanficsbackend.service.dto.UserRequestDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRequestDTOAssembler extends AbstractRequestDTOAssembler<User, UserRequestDTO, UserRequestDTO> {
    public UserRequestDTOAssembler() {
        super(User.class, UserRequestDTO.class, UserRequestDTO.class);
    }
}
