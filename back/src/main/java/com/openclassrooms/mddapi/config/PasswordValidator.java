package com.openclassrooms.mddapi.config;

import com.openclassrooms.mddapi.model.annotation.ValidPassword;
import com.openclassrooms.mddapi.security.services.UserDetailServiceImpl;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final Logger logger = LoggerFactory.getLogger(PasswordValidator.class);

    @Override
    public void initialize(ValidPassword constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        logger.info("Validating password: {}", password);
        if (password == null) {
            return false;
        }

        //Regex pour valider que le mot de passe contient au moins 8 caractères, une majuscule, une minuscule, un chiffre et un caractère spécial
        String passwordPattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return password.matches(passwordPattern);
    }
}
