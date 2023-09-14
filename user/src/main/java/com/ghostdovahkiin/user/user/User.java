package com.ghostdovahkiin.user.user;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder(builderClassName = "Builder")
public class User implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1485457345872034987L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int age;

    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Sex sex;

    public static User to(UserDTO dto) {
        return User
                .builder()
                .name(dto.getName())
                .age(dto.getAge())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .sex(dto.getSex())
                .build();
    }
}
