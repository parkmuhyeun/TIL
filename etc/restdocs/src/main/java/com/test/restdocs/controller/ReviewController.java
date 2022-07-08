package com.test.restdocs.controller;

import com.test.restdocs.dto.ReviewCreateRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {

    @PostMapping("/reviews")
    public ResponseEntity<Void> create(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/reviews/1")
                .build();
    }

    @PostMapping("/reviews1")
    public ResponseEntity<Void> create1(@RequestBody ReviewCreateRequest reviewCreateRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", "/reviews1/1")
                .build();
    }
}
