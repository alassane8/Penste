package com.example.penste.user.adapter.out.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "email", unique = true, length = 100)
    private String email;

    @Column(name = "phone_number", unique = true, length = 100)
    private String phoneNumber;

    @Column(name = "created_at", nullable = false, length = 100)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false, length = 100)
    private LocalDateTime updatedAt;
}
