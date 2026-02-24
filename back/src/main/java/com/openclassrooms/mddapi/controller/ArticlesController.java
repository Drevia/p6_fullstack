package com.openclassrooms.mddapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ArticlesController {

    public ResponseEntity<?> getAllArticles() {
        // Logique pour récupérer tous les articles
        return ResponseEntity.ok("Liste de tous les articles");
    }

    public ResponseEntity<?> getArticle() {
        // Logique pour récupérer un article spécifique
        return ResponseEntity.ok("Détails de l'article");
    }

    public ResponseEntity<?> createArticle() {
        // Logique pour créer un nouvel article
        return ResponseEntity.ok("Article créé");
    }
}
