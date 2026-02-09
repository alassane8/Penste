package com.example.penste.user.adapter.in.web.dto;

import com.example.penste.user.domain.exception.InvalidCommandException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UpdateUserCommand {
    private final String uuid;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phoneNumber;
    private final String password;

    public static UpdateUserCommand createCommandFrom(UserRequestBody requestBody) {
        validateRequestBody(requestBody);

        return UpdateUserCommand.builder()
                .uuid(requestBody.getUuid())
                .firstName(requestBody.getFirstName())
                .lastName(requestBody.getLastName().trim())
                .email(requestBody.getEmail().trim().toLowerCase())
                .phoneNumber(requestBody.getPhoneNumber().trim())
                .build();
    }

    private static void validateRequestBody(UserRequestBody requestBody) {
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
        if (requestBody.getPhoneNumber() == null || requestBody.getPhoneNumber().trim().isEmpty()) {
            throw new InvalidCommandException("Le numéro de téléphone est obligatoire");
        }
    }

    private static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
}
