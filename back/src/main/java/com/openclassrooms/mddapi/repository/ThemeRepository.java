package com.openclassrooms.mddapi.repository;

import com.openclassrooms.mddapi.model.Themes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Themes, Long> {

    Optional<Themes> findByTitre(String titre);
}
