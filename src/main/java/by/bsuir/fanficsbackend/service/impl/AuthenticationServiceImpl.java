package by.bsuir.fanficsbackend.service.impl;

import by.bsuir.fanficsbackend.security.JwtResponse;
import by.bsuir.fanficsbackend.security.JwtTokenProvider;
import by.bsuir.fanficsbackend.service.AuthenticationService;
import by.bsuir.fanficsbackend.service.UserService;
import by.bsuir.fanficsbackend.service.dto.AuthenticationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RestController;

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
        return null;
    }
}
