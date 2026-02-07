package com.example.penste.user.adapter.in.web.dto;

import com.example.penste.user.domain.exception.InvalidCommandException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CreateUserCommand {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;

    public static CreateUserCommand createCommandFrom(CreateUserRequestBody requestBody) {
        validateRequestBody(requestBody);

        return CreateUserCommand.builder()
                .firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName().trim())
                .email(requestBody.getEmail().trim().toLowerCase())
                .password(requestBody.getPassword())
                .build();
    }

    private static void validateRequestBody(CreateUserRequestBody requestBody) {
        if (requestBody.getFirstName() == null || requestBody.getFirstName().trim().isEmpty()) {
            throw new InvalidCommandException("Le prénom est obligatoire");
        }
        if (requestBody.getLastName() == null || requestBody.getLastName().trim().isEmpty()) {
            throw new InvalidCommandException("Le nom est obligatoire");
        }

        if (requestBody.getEmail() == null || requestBody.getEmail().trim().isEmpty()) {
            throw new InvalidCommandException("L'email est obligatoire");
        }
        if (!isValidEmail(requestBody.getEmail())) {
            throw new InvalidCommandException("L'email n'est pas valide");
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
}
