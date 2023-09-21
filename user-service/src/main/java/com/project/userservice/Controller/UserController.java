package com.project.userservice.Controller;

import com.project.userservice.Dto.UserDto;
import com.project.userservice.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @GetMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public List<UserDto> getAllUsers (@RequestParam(required = false,defaultValue = "0") int pageNo,
                                     @RequestParam(required = false,defaultValue = "10")  int pageSize){
        return userService.getAllUsers(pageNo,pageSize);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto registerUsers(@RequestBody @Validated UserDto userDto){
        return userService.registerUsers(userDto);
    }
}
