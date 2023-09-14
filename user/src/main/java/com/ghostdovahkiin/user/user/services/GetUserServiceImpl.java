package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.exceptions.UserNotFoundException;
import com.ghostdovahkiin.user.user.User;
import com.ghostdovahkiin.user.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class GetUserServiceImpl implements GetUserService {
    private final UserRepository userRepository;


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }
}
