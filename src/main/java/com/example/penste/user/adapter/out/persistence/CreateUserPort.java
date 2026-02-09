package com.example.penste.user.adapter.out.persistence;

import com.example.penste.user.domain.model.User;


public interface CreateUserPort {

    /** Check if user exists by email
     * @return boolean of existing user by email
     */
    Boolean existsByEmail(String email);

    /** Save user return the saved user
     *  @return saved user
     *  @param userToSave user to be saved
     */
    UserEntity saveUser(User userToSave);
}
