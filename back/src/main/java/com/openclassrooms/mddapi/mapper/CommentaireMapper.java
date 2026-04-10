package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.dto.CommentaireDto;
import com.openclassrooms.mddapi.model.Commentaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentaireMapper {

    @Mapping(source = "username", target = "auteur")
    Commentaire toEntity(CommentaireDto dto, String username);

    CommentaireDto toDto(Commentaire entity);
}
