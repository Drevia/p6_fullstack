package com.openclassrooms.mddapi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ThemesController {

    public ResponseEntity<?> getAllThemes() {
        // Logique pour récupérer tous les thèmes
        return ResponseEntity.ok("Liste de tous les thèmes");
    }
}
