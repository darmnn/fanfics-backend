package by.bsuir.fanficsbackend.security;

public class JwtResponse {
    private Long userId;

    private String accessToken;

    private Boolean admin;

    public JwtResponse(Long userId, String accessToken, Boolean admin) {
        this.userId = userId;
        this.accessToken = accessToken;
        this.admin = admin;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAccessToken() {

        return accessToken;
    }

    public void setAccessToken(String accessToken) {

        this.accessToken = accessToken;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }
}
