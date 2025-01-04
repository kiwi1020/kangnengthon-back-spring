package com.hackathon.kangnengthon.controller;

import com.hackathon.kangnengthon.dto.CreateAccessTokenDto;
import com.hackathon.kangnengthon.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TokenApiController {

    private final TokenService tokenService;

    @PostMapping("/api/token")
    public ResponseEntity<CreateAccessTokenDto.CreateAccessTokenResponse> createNewAccessToken(@RequestBody CreateAccessTokenDto.CreateAccessTokenRequest request) {
        String newAccessToken = tokenService.createNewAccessToken(request.getRefreshToken());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CreateAccessTokenDto.CreateAccessTokenResponse(newAccessToken));
    }
}