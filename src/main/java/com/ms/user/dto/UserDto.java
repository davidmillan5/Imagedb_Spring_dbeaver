package com.ms.user.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String document;
    private String name;
    private String lastName;
    private boolean status;
    private String email;
}
