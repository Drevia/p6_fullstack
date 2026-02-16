package com.openclassrooms.mddapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Data
@Table(name = "themes")
public class Themes {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titre;
    private String description;
}
