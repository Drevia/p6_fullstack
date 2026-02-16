package com.openclassrooms.mddapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    public ResponseEntity<?> getProfil() {
        // Logique pour récupérer le profil de l'utilisateur
        return ResponseEntity.ok("Profil de l'utilisateur");
    }

    public ResponseEntity<?> updateProfil() {
        // Logique pour mettre à jour le profil de l'utilisateur
        return ResponseEntity.ok("Profil mis à jour");
    }
}
