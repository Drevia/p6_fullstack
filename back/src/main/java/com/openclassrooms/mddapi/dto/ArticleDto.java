package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Commentaire;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleDto {

    private String titre;
    private String contenu;
    private String auteur;
    private Date datePublication;
    private List<Commentaire> commentaires;
}
