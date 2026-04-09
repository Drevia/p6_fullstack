package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.model.Themes;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ThemesMapper {

    @Mapping(source = "id", target = "id")
    ThemeDto toDto(Themes themes);

    @Mapping(source = "id", target = "id")
    Themes toEntity(ThemeDto themeDto);
}
