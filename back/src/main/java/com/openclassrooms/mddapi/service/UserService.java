package com.openclassrooms.mddapi.service;

import com.openclassrooms.mddapi.dto.UserDto;
import com.openclassrooms.mddapi.mapper.UserMapper;
import com.openclassrooms.mddapi.model.Utilisateur;
import com.openclassrooms.mddapi.payload.request.UpdateProfilRequest;
import com.openclassrooms.mddapi.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserDto getProfil(String email) {
        Utilisateur utilisateur = userRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Utilisateur non trouvé avec l'email: " + email));

        return userMapper.toDto(utilisateur);
    }

    public UserDto updateProfil(String email, UpdateProfilRequest request){
        Utilisateur utilisateur = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        utilisateur.setUsername(request.getUsername());
        utilisateur.setEmail(request.getEmail());

        if (request.getPassword() != null && !request.getPassword().isBlank()) {
            utilisateur.setMotDePasse(passwordEncoder.encode(request.getPassword()));
        }

        return userMapper.toDto(userRepository.save(utilisateur));
    }

    public UserDto updateSubscriptions(String email, UserDto userDto) {
        Utilisateur utilisateur = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
        utilisateur.setAbonnements(userDto.getAbonnements());
        return userMapper.toDto(userRepository.save(utilisateur));
    }
}
