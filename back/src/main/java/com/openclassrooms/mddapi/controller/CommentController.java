package com.openclassrooms.mddapi.controller;

import com.openclassrooms.mddapi.dto.CommentaireDto;
import com.openclassrooms.mddapi.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/articles/{articlesId}/comments")
    public ResponseEntity<?> getComments(@PathVariable Long articlesId) {
        return ResponseEntity.ok(commentService.getCommentsByArticle(articlesId));
    }

    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<?> addComment(@PathVariable Long articleId, @RequestBody CommentaireDto commentaireDto,
                                        Authentication authentication) {
        String email = authentication.getName();
        return ResponseEntity.ok(commentService.addComment(articleId, commentaireDto, email));
    }
}
