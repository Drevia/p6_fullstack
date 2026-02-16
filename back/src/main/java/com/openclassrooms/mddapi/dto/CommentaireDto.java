package com.openclassrooms.mddapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CommentaireDto {

    private String auteur;
    private String contenu;
    private Date datePublication;
}
