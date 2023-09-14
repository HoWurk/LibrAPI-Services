package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.user.User;

import java.util.List;

@FunctionalInterface
public interface ListUserService {
    List<User> findAll();
}
