package com.openclassrooms.mddapi.payload.request;

import lombok.Data;

@Data
public class ArticleRequest {

    private String titre;
    private String contenu;
    private String themeTitre;
}
