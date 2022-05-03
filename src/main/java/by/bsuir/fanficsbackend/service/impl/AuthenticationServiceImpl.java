package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.exception.JwtAuthenticationException;
import by.bsuir.fanficsbackend.security.JwtResponse;
import by.bsuir.fanficsbackend.security.JwtTokenProvider;
import by.bsuir.fanficsbackend.service.AuthenticationService;
import by.bsuir.fanficsbackend.service.UserService;
import by.bsuir.fanficsbackend.service.dto.AuthenticationDTO;
import by.bsuir.fanficsbackend.service.dto.UserResponseDTO;
import by.bsuir.fanficsbackend.service.dto.UserSearchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Override
    public String authenticate(AuthenticationDTO authenticationDTO) {
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        userSearchDTO.setName(authenticationDTO.getUsername());
        userSearchDTO.setPassword(authenticationDTO.getPassword());

        List<UserResponseDTO> userResponseDTO = userService.search(userSearchDTO);

        if (userResponseDTO.isEmpty()) {
            throw new JwtAuthenticationException("Wrong username or password");
        }

        String userRole;
        if (userResponseDTO.get(0).getAdmin()) {
            userRole = "admin";
        } else {
            userRole = "user";
        }

        return jwtTokenProvider.createToken(userResponseDTO.get(0).getName(), userRole);
    }
}
