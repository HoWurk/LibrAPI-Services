package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.exceptions.UserAlreadyExistsException;
import com.ghostdovahkiin.user.user.User;
import com.ghostdovahkiin.user.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SaveUserServiceImpl implements SaveUserService{
    private final UserRepository userRepository;

    @Override
    public void save(User user) {
        if(userRepository.existsByEmail(user.getEmail()) || userRepository.existsByPhone(user.getPhone())){
            throw new UserAlreadyExistsException();
        }
        userRepository.save(user);
    }
}
