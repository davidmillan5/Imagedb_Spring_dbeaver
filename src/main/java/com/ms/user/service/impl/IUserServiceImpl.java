package com.ms.user.service.impl;

import com.ms.user.dto.UserDto;
import com.ms.user.model.UserEntity;
import com.ms.user.repository.IUserRepository;
import com.ms.user.service.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class IUserServiceImpl implements IUserService {

    private final IUserRepository iUserRepository;
    @Override
    public ResponseEntity<UserEntity> save(UserDto userDto) {
        String uuid = UUID.randomUUID().toString();
        UserEntity userEntity = UserEntity
                .builder()
                .id(uuid)
                .name(userDto.getName())
                .lastName(userDto.getLastName())
                .document(userDto.getDocument())
                .email(userDto.getEmail())
                .status(true)
                .build();

        var newUser = this.iUserRepository.save(userEntity);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(newUser);
    }
}
