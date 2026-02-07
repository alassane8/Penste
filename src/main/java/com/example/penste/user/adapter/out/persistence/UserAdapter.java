package com.example.penste.user.adapter.out.persistence;


import com.example.penste.user.domain.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class UserAdapter {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(userMapper::mapToUserEntity).toList();
    }


}
