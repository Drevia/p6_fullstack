package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.dto.CommentaireDto;
import com.openclassrooms.mddapi.model.Commentaire;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentaireMapper {

    Commentaire toEntity(CommentaireDto dto);

    CommentaireDto toDto(Commentaire entity);
}
