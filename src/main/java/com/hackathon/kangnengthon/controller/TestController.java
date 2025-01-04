package com.hackathon.kangnengthon.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController {

    @GetMapping("/rest")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("GET Method has been called");
    }

    @PostMapping("/rest")
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("POST Method has been called");
    }

    @PutMapping("/rest")
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("PUT Method has been called");
    }

    @DeleteMapping("/rest")
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("DELETE Method has been called");
    }
}
