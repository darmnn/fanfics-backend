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
    public JwtResponse authenticate(AuthenticationDTO authenticationDTO) {
        UserSearchDTO userSearchDTO = new UserSearchDTO();
        userSearchDTO.setName(authenticationDTO.getUsername());
        userSearchDTO.setPassword(authenticationDTO.getPassword());

        List<UserResponseDTO> userResponseDTO = userService.search(userSearchDTO);

        if (userResponseDTO.isEmpty()) {
            throw new JwtAuthenticationException("Wrong username or password");
        }
        else if (userResponseDTO.get(0).getBlocked()) {
            throw new JwtAuthenticationException("This user is blocked");
        }

        String userRole;
        Boolean isAdmin;
        if (userResponseDTO.get(0).getAdmin()) {
            userRole = "admin";
            isAdmin = true;
        } else {
            userRole = "user";
            isAdmin = false;
        }

        String token = jwtTokenProvider.createToken(userResponseDTO.get(0).getName(), userRole);

        return new JwtResponse(userResponseDTO.get(0).getId(), token, isAdmin);
    }
}
