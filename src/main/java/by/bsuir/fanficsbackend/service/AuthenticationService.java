package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.security.JwtResponse;
import by.bsuir.fanficsbackend.service.dto.AuthenticationDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/login")
public interface AuthenticationService {
    @PostMapping
    JwtResponse authenticate(@RequestBody AuthenticationDTO authenticationDTO);
}
