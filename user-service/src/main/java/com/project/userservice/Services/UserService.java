package com.project.userservice.Services;

import com.project.userservice.Dto.UserDto;

import java.util.List;

public interface UserService {
    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<UserDto> getAllUsers(int pageNo, int pageSize);
    /**
     * This method registers a new user
     *
     * @param userDto - the new user to be registered
     */
    UserDto registerUsers(UserDto userDto);
}
