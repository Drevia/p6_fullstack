package com.openclassrooms.mddapi.service;

import com.openclassrooms.mddapi.dto.ThemeDto;
import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.mapper.ThemesMapper;
import com.openclassrooms.mddapi.model.Themes;
import com.openclassrooms.mddapi.model.Utilisateur;
import com.openclassrooms.mddapi.repository.ThemeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ThemesService {

    @Autowired
    private ThemeRepository themeRepository;

    @Autowired
    private ThemesMapper themesMapper;

    @Autowired
    private UserService userService;

    public List<ThemeDto> getAllThemes() {
        return themeRepository.findAll()
                .stream().map(themesMapper::toDto)
                .collect(Collectors.toList());
    }

    public Themes getThemeByTitle(String title) {
        return themeRepository.findByTitre(title)
                .orElseThrow(() -> new RuntimeException("Theme not found"));
    }

    public ThemeDto subscribe(String userEmail, Long themeId) {
        UserDto user = userService.getProfil(userEmail);
        Themes theme = themeRepository.findById(themeId)
                .orElseThrow(() -> new RuntimeException("Theme not found with id: " + themeId));

        user.getAbonnements().add(theme);
        userService.updateSubscriptions(userEmail, user);
        return themesMapper.toDto(theme);
    }

    public void unsubscribe(String userEmail, Long themeId) {
        UserDto user = userService.getProfil(userEmail);
        Themes theme = themeRepository.findById(themeId)
                .orElseThrow(() -> new RuntimeException("Theme not found with id: " + themeId));

        user.getAbonnements().remove(theme);
        userService.updateSubscriptions(userEmail, user);
     }

    public List<ThemeDto> getUserSubscriptions(String userEmail) {
        UserDto user = userService.getProfil(userEmail);
        return user.getAbonnements()
                .stream().map(themesMapper::toDto)
                .collect(Collectors.toList());
    }
}
