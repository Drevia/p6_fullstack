-- Suppression des tables si elles existent (ordre important à cause des FK)
DROP TABLE IF EXISTS utilisateur_themes;
DROP TABLE IF EXISTS commentaires;
DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS utilisateurs;
DROP TABLE IF EXISTS themes;

-- ============================
-- TABLE ARTICLES
-- ============================
CREATE TABLE articles (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          titre VARCHAR(255) NOT NULL,
                          contenu TEXT NOT NULL,
                          auteur VARCHAR(255) NOT NULL,
                          date_publication DATETIME
);

-- ============================
-- TABLE COMMENTAIRES
-- ============================
CREATE TABLE commentaires (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              auteur VARCHAR(255) NOT NULL,
                              contenu TEXT NOT NULL,
                              date_publication DATETIME,
                              article_id BIGINT,
                              CONSTRAINT fk_commentaire_article
                                  FOREIGN KEY (article_id)
                                      REFERENCES articles(id)
                                      ON DELETE CASCADE
);

-- ============================
-- TABLE THEMES
-- ============================
CREATE TABLE themes (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        titre VARCHAR(255) NOT NULL,
                        description TEXT
);

-- ============================
-- TABLE UTILISATEURS
-- ============================
CREATE TABLE utilisateurs (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              username VARCHAR(255) NOT NULL UNIQUE,
                              email VARCHAR(255) NOT NULL UNIQUE,
                              mot_de_passe VARCHAR(255) NOT NULL
);

-- ============================
-- TABLE DE JOINTURE UTILISATEUR <-> THEMES
-- (ManyToMany)
-- ============================
CREATE TABLE utilisateur_themes (
                                    utilisateur_id BIGINT NOT NULL,
                                    theme_id BIGINT NOT NULL,
                                    PRIMARY KEY (utilisateur_id, theme_id),
                                    CONSTRAINT fk_ut_utilisateur
                                        FOREIGN KEY (utilisateur_id)
                                            REFERENCES utilisateurs(id)
                                            ON DELETE CASCADE,
                                    CONSTRAINT fk_ut_theme
                                        FOREIGN KEY (theme_id)
                                            REFERENCES themes(id)
                                            ON DELETE CASCADE
);