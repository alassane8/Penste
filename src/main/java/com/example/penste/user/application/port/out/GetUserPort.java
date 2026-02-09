package com.example.penste.user.application.port.out;

import com.example.penste.user.adapter.out.persistence.UserEntity;

import java.util.List;
import java.util.Optional;

public interface GetUserPort {

    /** Find All Users
     * @return list of users
     */
    List<UserEntity> findAllUsers();

    /** Check if user exists by email
     * @return boolean of existing user by email
     */
    Boolean existsByEmail(String email);

    /** Check if user exists by id
     * @return boolean of existing user by id
     */
    Optional<UserEntity> findById(String uuid);
}
