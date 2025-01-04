package com.hackathon.kangnengthon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CreateAccessTokenDto {
    @Getter
    @AllArgsConstructor
    public static class CreateAccessTokenRequest {
        private String refreshToken;
    }

    @AllArgsConstructor
    @Getter
    public static class CreateAccessTokenResponse {
        private String accessToken;
    }
}