package com.ghostdovahkiin.user.user.builders;

import com.ghostdovahkiin.user.user.Sex;
import com.ghostdovahkiin.user.user.User;

public class UserBuilder {
    public static User.Builder createUser() {
        return User.builder()
                .id(145485989485039832L)
                .name("Pedro")
                .age(22)
                .phone("+5583986862912")
                .email("pedro.sousa@dcx.ufpb.br")
                .sex(Sex.MALE);
    }
}
