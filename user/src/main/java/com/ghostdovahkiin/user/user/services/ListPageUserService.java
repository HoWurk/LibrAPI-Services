package com.ghostdovahkiin.user.user.services;

import com.ghostdovahkiin.user.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@FunctionalInterface
public interface ListPageUserService {

    Page<User> listPages(Pageable pageable);
}
