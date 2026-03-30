package com.openclassrooms.mddapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String contenu;
    private String auteur;

    @Column(name = "date_publication")
    private Date datePublication;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "article_id")
    private List<Commentaire> commentaires;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Themes theme;
}
