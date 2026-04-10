package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.payload.request.UpdateProfilRequest;
import com.openclassrooms.mddapi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/me")
    public ResponseEntity<?> getProfil(Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(userService.getProfil(email));
    }

    @PutMapping("/user/me")
    public ResponseEntity<?> updateProfil(Authentication authentication, @RequestBody UpdateProfilRequest request) {
        String email = authentication.getName();
        return ResponseEntity.ok(userService.updateProfil(email, request));
    }
}
