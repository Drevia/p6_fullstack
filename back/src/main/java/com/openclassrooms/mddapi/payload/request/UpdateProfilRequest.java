package com.openclassrooms.mddapi.payload.request;

import lombok.Data;

@Data
public class UpdateProfilRequest {

    private String username;
    private String email;
    private String password;
}
