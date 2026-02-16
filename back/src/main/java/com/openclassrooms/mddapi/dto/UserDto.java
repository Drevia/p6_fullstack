package com.openclassrooms.mddapi.dto;

import com.openclassrooms.mddapi.model.Themes;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private String username;
    private String email;
    private List<Themes> abonnements;
}
