package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.service.ThemesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
