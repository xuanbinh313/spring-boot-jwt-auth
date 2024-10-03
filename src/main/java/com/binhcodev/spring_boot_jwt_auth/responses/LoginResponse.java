package com.binhcodev.spring_boot_jwt_auth.responses;

public class LoginResponse {
    private String token;

    private long expireIn;

    public LoginResponse setToken(String token) {
        this.token = token;
        return this;
    }

    public LoginResponse setExpireIn(long expireIn) {
        this.expireIn = expireIn;
        return this;
    }

    public String getToken() {
        return token;
    }

    public long getExpireIn() {
        return expireIn;
    }
}
