package com.loungeguru.users;

public class Tokens
{
    public String accessToken;
    public String refreshToken;

    public Tokens(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
