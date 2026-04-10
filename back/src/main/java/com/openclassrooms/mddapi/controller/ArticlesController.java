package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.payload.request.ArticleRequest;
import com.openclassrooms.mddapi.service.ArticlesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ArticlesController {

    @Autowired
    private ArticlesService articlesService;

    @GetMapping("/articles")
    public ResponseEntity<?> getAllArticles() {
        return ResponseEntity.ok(articlesService.getAllArticles());
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<?> getArticle(@PathVariable Long id) {
        return ResponseEntity.ok(articlesService.getArticle(id));
    }

    @GetMapping("/articles/feed")
    public ResponseEntity<?> getFeed(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(articlesService.getFeed(email));
    }

    @PostMapping("/articles")
    public ResponseEntity<?> createArticle(Authentication authentication, @RequestBody ArticleRequest articleRequest) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(articlesService.createArticle(articleRequest, userEmail));
    }


}
