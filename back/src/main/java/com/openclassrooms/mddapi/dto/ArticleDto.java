package com.openclassrooms.mddapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.mddapi.model.Commentaire;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleDto {

    private Long id;
    private String titre;
    private String contenu;
    private String auteur;
    private Date datePublication;
    private List<CommentaireDto> commentaires;
    private ThemeDto themeDtos;
}
