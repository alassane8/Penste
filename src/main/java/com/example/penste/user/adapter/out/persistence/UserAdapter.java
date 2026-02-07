package com.example.penste.user.adapter.out.persistence;

import com.example.penste.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserAdapter {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity saveUser(User createUser) {

        var userEntity = userMapper.mapToUserEntity(createUser);

        return userRepository.save(userEntity);
    }

    public boolean existsByEmail(String email) {
        log.debug("Adapter: Vérification de l'existence de l'email: {}", email);
        return userRepository.existsByEmail(email);
    }
}
