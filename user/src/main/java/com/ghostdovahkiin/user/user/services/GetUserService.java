package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.user.User;

@FunctionalInterface
public interface GetUserService {
    User findById(Long id);
}
