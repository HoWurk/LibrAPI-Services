package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.user.User;
import com.ghostdovahkiin.user.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ListPageUserServiceImpl implements ListPageUserService{

    private final UserRepository userRepository;

    @Override
    public Page<User> listPages(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
