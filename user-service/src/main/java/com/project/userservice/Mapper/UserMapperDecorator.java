package com.project.userservice.Mapper;

import com.project.userservice.Dto.UserDto;
import com.project.userservice.Model.User;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
@RequiredArgsConstructor
public class UserMapperDecorator{
    private final ModelMapper mapper;
    public User toEntity(UserDto userDto){

        User mapped = mapper.map(userDto, User.class);
        return mapped;
    }
    public UserDto toDto(User user){
        UserDto userDto = mapper.map(user, UserDto.class);
        return userDto;
    }
}
