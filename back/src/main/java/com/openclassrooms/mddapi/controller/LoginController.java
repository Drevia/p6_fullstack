package com.openclassrooms.mddapi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/auth")
public class LoginController {

    public String login() {
        // Logique pour afficher la page de connexion
        return "login"; // Retourne le nom de la vue pour la page de connexion
    }

    public String register() {
        // Logique pour afficher la page d'inscription
        return "register"; // Retourne le nom de la vue pour la page d'inscription
    }
}
