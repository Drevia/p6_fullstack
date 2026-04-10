package com.openclassrooms.mddapi.service;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.CommentaireDto;
import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.mapper.CommentaireMapper;
import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.model.Commentaire;
import com.openclassrooms.mddapi.repository.ArticlesRepository;
import com.openclassrooms.mddapi.repository.CommentaireRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    @Autowired
    private CommentaireRepository commentaireRepository;

    @Autowired
    private CommentaireMapper commentaireMapper;

    @Autowired
    private ArticlesService articlesService;

    @Autowired
    private ArticlesRepository articlesRepository;

    @Autowired
    private UserService userService;

    public List<CommentaireDto> getCommentsByArticle(Long articleId) {
        ArticleDto articleDto = articlesService.getArticle(articleId);
        return articleDto.getCommentaires();
    }

    public CommentaireDto addComment(Long articleId, CommentaireDto commentaireDto, String userEmail) {
        Article article = articlesRepository.findById(articleId)
                .orElseThrow(() -> new RuntimeException("Article not found with id: " + articleId));


        UserDto userDto = userService.getProfil(userEmail);

        Commentaire commentaire = commentaireMapper.toEntity(commentaireDto, userDto.getUsername());
        commentaire.setDatePublication(new Date());
        article.getCommentaires().add(commentaire);
        articlesRepository.save(article);

        return commentaireMapper.toDto(commentaire);
    }
}
