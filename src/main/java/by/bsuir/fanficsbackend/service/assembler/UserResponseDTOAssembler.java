package by.bsuir.fanficsbackend.service.assembler;

import by.bsuir.fanficsbackend.persistence.entity.User;
import by.bsuir.fanficsbackend.service.dto.UserResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class UserResponseDTOAssembler extends AbstractResponseDTOAssembler<User, UserResponseDTO> {
    public UserResponseDTOAssembler() {
        super(UserResponseDTO.class, User.class);
    }
}
