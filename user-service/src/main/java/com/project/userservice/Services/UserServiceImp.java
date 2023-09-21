package com.project.userservice.Services;

import com.project.userservice.Dto.UserDto;
import com.project.userservice.Mapper.UserMapperDecorator;
import com.project.userservice.Model.User;
import com.project.userservice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserRepository userRepository;
    private final UserMapperDecorator userMapperDecorator;
    @Override
    public List<UserDto> getAllUsers(int pageNo, int pageSize) {

        PageRequest pageRequest = PageRequest.of(pageNo,pageSize);
        return userRepository.findAll(pageRequest).getContent().stream()
                .map(userMapperDecorator::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto registerUsers(UserDto userDto) {

        // Validate input data
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty() || userDto.getEmail() == null || userDto.getEmail().isEmpty() || userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            throw new IllegalArgumentException("Username, email, and password are required.");
        }
        if(userRepository.existsByUsername(userDto.getUsername()))
            throw new RuntimeException("Username has been taken. Please enter a new UserName");
        if (userRepository.existsByEmail(userDto.getEmail()))
            throw new RuntimeException("Email is already registered.");
        User savedUser = userRepository.save(userMapperDecorator.toEntity(userDto));
        return userMapperDecorator.toDto(savedUser);
    }
}
