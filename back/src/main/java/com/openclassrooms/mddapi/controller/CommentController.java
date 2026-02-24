package com.openclassrooms.mddapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CommentController {

    public ResponseEntity<?> getComments() {
        // Logique pour récupérer les commentaires d'un article
        return ResponseEntity.ok("Liste des commentaires de l'article");
    }

    public ResponseEntity<?> addComment() {
        // Logique pour ajouter un commentaire à un article
        return ResponseEntity.ok("Commentaire ajouté");
    }
}
