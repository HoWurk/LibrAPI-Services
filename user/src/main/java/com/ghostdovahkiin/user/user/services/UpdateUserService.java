package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.user.UserDTO;

@FunctionalInterface
public interface UpdateUserService {
    void update(UserDTO user, Long id);
}
