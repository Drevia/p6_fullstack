package com.openclassrooms.mddapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "commentaires")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String auteur;
    private String contenu;

    @Column(name = "date_publication")
    private Date datePublication;
}
