package com.ghostdovahkiin.user.user.v1;

import com.ghostdovahkiin.user.user.User;
import com.ghostdovahkiin.user.user.UserDTO;
import com.ghostdovahkiin.user.user.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/v1/api/users")
public class UserController {

    private final ListUserService listUserService;
    private final GetUserService getUserService;
    private final SaveUserService saveUserService;
    private final DeleteUserService deleteUserService;
    private final UpdateUserService updateUserService;
    private final ListPageUserService listPageUserService;

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll() {
        return UserDTO.fromAll(listUserService.findAll());
    }

    @GetMapping(path = "/")
    @ResponseStatus(HttpStatus.OK)
    public Page<UserDTO> listPageUser(Pageable pageable) {
        return UserDTO.fromPage(listPageUserService.listPages(pageable));
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findByID(@PathVariable Long id) {
        return UserDTO.from(getUserService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@Valid @RequestBody UserDTO userDTO){
        saveUserService.save(User.to(userDTO));
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        deleteUserService.delete(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@Valid @RequestBody UserDTO userDTO, @PathVariable Long id){
        updateUserService.update(userDTO, id);
    }
}
