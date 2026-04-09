package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.service.ThemesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ThemesController {

    @Autowired
    private ThemesService themesService;

    @GetMapping("/themes")
    public ResponseEntity<?> getAllThemes() {
        return ResponseEntity.ok(themesService.getAllThemes());
    }

    @PostMapping("/themes/{themeId}/subscribe")
    public ResponseEntity<?> subscribeToTheme(Authentication authentication, @PathVariable Long themeId) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(themesService.subscribe(userEmail, themeId));
    }

    @DeleteMapping("/themes/{themeId}/unsubscribe")
    public ResponseEntity<?> unsubscribe(Authentication authentication, @PathVariable Long themeId) {
        String userEmail = authentication.getName();
        themesService.unsubscribe(userEmail, themeId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/themes/abonnements")
    public ResponseEntity<?> getUserSubscriptions(Authentication authentication) {
        String userEmail = authentication.getName();
        return ResponseEntity.ok(themesService.getUserSubscriptions(userEmail));
    }
}
