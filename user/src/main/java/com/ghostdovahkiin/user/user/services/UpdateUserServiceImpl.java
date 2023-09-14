package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.exceptions.UserNotFoundException;
import com.ghostdovahkiin.user.user.User;
import com.ghostdovahkiin.user.user.UserDTO;
import com.ghostdovahkiin.user.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateUserServiceImpl implements UpdateUserService{
    private final UserRepository userRepository;

    @Override
    public void update(UserDTO user, Long id) {
        User userFound = userRepository.findById(id).orElseThrow(UserNotFoundException::new);

        userFound.setName(user.getName());
        userFound.setAge(user.getAge());
        userFound.setPhone(user.getPhone());
        userFound.setEmail(user.getEmail());
        userFound.setSex(user.getSex());

        userRepository.save(userFound);
    }
}
