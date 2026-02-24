package com.openclassrooms.mddapi.model;

import com.openclassrooms.mddapi.model.annotation.ValidPassword;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;

@Data
@Entity
@Table(name = "utilisateurs", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@EqualsAndHashCode(of = {"id"})
public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String username;
    @NonNull
    private String email;

    @NonNull
    @Column(name = "mot_de_passe")
    private String motDePasse;

    @ManyToMany
    @JoinTable(
        name = "utilisateur_abonnements",
        joinColumns = @JoinColumn(name = "utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name = "theme_id")
    )
    private List<Themes> abonnements;
}
