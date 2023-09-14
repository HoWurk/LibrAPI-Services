package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.user.User;

@FunctionalInterface
public interface SaveUserService {
    void save(User user);
}
