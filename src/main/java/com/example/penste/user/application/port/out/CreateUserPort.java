package com.example.penste.user.application.port.out;

import com.example.penste.user.adapter.out.persistence.UserEntity;


public interface CreateUserPort {

    /** Save user return the saved user
     *  @return saved user
     *  @param userToSave user to be saved
     */
    UserEntity saveUser(UserEntity userToSave);
}
