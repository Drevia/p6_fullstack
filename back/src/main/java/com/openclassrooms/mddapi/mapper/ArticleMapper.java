package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.dto.ArticleDto;
import com.openclassrooms.mddapi.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CommentaireMapper.class, ThemesMapper.class})
public interface ArticleMapper {


    List<ArticleDto> toArticleDtos(List<Article> articles);

    @Mapping(source = "theme", target = "themeDtos")
    @Mapping(source = "id", target = "id")
    ArticleDto toArticleDto(Article article);

    @Mapping(source = "themeDtos", target = "theme")
    Article toEntity(ArticleDto articleDto);

}
