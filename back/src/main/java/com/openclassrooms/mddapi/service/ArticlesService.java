package com.openclassrooms.mddapi.service;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.mapper.ArticleMapper;
import com.openclassrooms.mddapi.model.Article;
import com.openclassrooms.mddapi.model.Themes;
import com.openclassrooms.mddapi.payload.request.ArticleRequest;
import com.openclassrooms.mddapi.repository.ArticlesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticlesService {

    private final ArticlesRepository articleRepository;

    private final ArticleMapper articleMapper;

    private final ThemesService themesService;

    private final UserService userService;

    public List<ArticleDto> getAllArticles() {
        List<Article> articleList = articleRepository.findAll();
        return articleMapper.toArticleDtos(articleList);
    }

    public ArticleDto getArticle(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Article not found"));

        return articleMapper.toArticleDto(article);
    }

    public ArticleDto createArticle(ArticleRequest articleRequest, String userEmail) {
        Themes theme = themesService.getThemeByTitle(articleRequest.getThemeTitre());

        UserDto userDto = userService.getProfil(userEmail);

        Article article = new Article();
        article.setTitre(articleRequest.getTitre());
        article.setContenu(articleRequest.getContenu());
        article.setAuteur(userDto.getUsername());
        article.setDatePublication(new Date());
        article.setTheme(theme);

        return articleMapper.toArticleDto(articleRepository.save(article));
    }
}
