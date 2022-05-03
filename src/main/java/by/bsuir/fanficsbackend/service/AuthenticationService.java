package by.bsuir.fanficsbackend.service;

import by.bsuir.fanficsbackend.security.JwtResponse;
import by.bsuir.fanficsbackend.service.dto.AuthenticationDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface AuthenticationService {
    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    String authenticate(@RequestBody AuthenticationDTO authenticationDTO);
}
