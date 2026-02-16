package com.openclassrooms.mddapi.model;

import com.openclassrooms.mddapi.model.annotation.ValidPassword;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    @ValidPassword
    private String motDePasse;

    @ManyToMany
    @JoinTable(
        name = "utilisateur_abonnements",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "theme_id")
    )
    private List<Themes> abonnements;
}
