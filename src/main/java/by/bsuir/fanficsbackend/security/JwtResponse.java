package by.bsuir.fanficsbackend.security;

import java.time.LocalDateTime;

public class JwtResponse {

    private String username;

    private String accessToken;

    private LocalDateTime accessTokenExpiration;

    public JwtResponse(String username, String accessToken, LocalDateTime accessTokenExpiration) {
        this.username = username;
        this.accessToken = accessToken;
        this.accessTokenExpiration = accessTokenExpiration;
    }

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getAccessToken() {

        return accessToken;
    }

    public void setAccessToken(String accessToken) {

        this.accessToken = accessToken;
    }

    public LocalDateTime getAccessTokenExpiration() {
        return accessTokenExpiration;
    }

    public void setAccessTokenExpiration(LocalDateTime accessTokenExpiration) {
        this.accessTokenExpiration = accessTokenExpiration;
    }
}
