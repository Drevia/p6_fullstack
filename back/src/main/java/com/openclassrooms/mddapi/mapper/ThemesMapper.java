package com.openclassrooms.mddapi.mapper;

import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.model.Themes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ThemesMapper {

    ThemeDto toDto(Themes themes);
    Themes toEntity(ThemeDto themeDto);
}
