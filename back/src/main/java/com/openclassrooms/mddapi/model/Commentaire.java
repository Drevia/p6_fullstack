package com.openclassrooms.mddapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Date datePublication;
}
