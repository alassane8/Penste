package com.example.penste.user.adapter.out.persistence;

import java.util.List;

public interface GetUserPort {

    /** Find All Users
     * @return list of users
     */
    List<UserEntity> findAllUsers();
}
