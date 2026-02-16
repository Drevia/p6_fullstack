package com.openclassrooms.mddapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApplicationController {

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

    public ResponseEntity<?> getComments() {
        // Logique pour récupérer les commentaires d'un article
        return ResponseEntity.ok("Liste des commentaires de l'article");
    }

    public ResponseEntity<?> addComment() {
        // Logique pour ajouter un commentaire à un article
        return ResponseEntity.ok("Commentaire ajouté");
    }

    public ResponseEntity<?> getAllThemes() {
        // Logique pour récupérer tous les thèmes
        return ResponseEntity.ok("Liste de tous les thèmes");
    }
}
