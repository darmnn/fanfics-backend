package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.persistence.entity.User;
import by.bsuir.fanficsbackend.persistence.repository.UserRepository;
import by.bsuir.fanficsbackend.service.AbstractCrudService;
import by.bsuir.fanficsbackend.service.UserService;
import by.bsuir.fanficsbackend.service.assembler.UserRequestDTOAssembler;
import by.bsuir.fanficsbackend.service.assembler.UserResponseDTOAssembler;
import by.bsuir.fanficsbackend.service.dto.SearchDTO;
import by.bsuir.fanficsbackend.service.dto.UserRequestDTO;
import by.bsuir.fanficsbackend.service.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl extends AbstractCrudService<UserResponseDTO, UserRequestDTO, UserRequestDTO, SearchDTO,
        User, UserRepository> implements UserService, UserDetailsService {
    @Autowired
    public UserServiceImpl(UserResponseDTOAssembler responseDTOAssembler, UserRequestDTOAssembler requestAssembler) {
        super(responseDTOAssembler, requestAssembler, User.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public boolean hasUpdateAccess(Long id) {
        return false;
    }
}
