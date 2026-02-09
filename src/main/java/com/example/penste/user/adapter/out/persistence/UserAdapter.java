package com.example.penste.user.adapter.out.persistence;

import com.example.penste.user.application.port.out.CreateUserPort;
import com.example.penste.user.application.port.out.GetUserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAdapter implements CreateUserPort, GetUserPort {

    private final UserRepository userRepository;

    @Override
    public List<UserEntity> findAllUsers() {
        log.debug("Adapter: Récupération de tous les utilisateurs");
        return userRepository.findAll();
    }

    @Override
    public UserEntity saveUser(UserEntity userEntity) {
        log.debug("Adapter: Sauvegarde de l'utilisateur avec email: {}", userEntity.getEmail());
        return userRepository.save(userEntity);
    }

    @Override
    public Boolean existsByEmail(String email) {
        log.debug("Adapter: Vérification de l'existence de l'email: {}", email);
        return userRepository.existsByEmail(email);
    }

    @Override
    public Optional<UserEntity> findById(String uuid) {
        log.debug("Adapter: Recherche de l'utilisateur avec UUID: {}", uuid);
        return userRepository.findByUuid(uuid);
    }
}