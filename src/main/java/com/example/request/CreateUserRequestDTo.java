package com.example.request;

import lombok.*;
import models.UserInfo;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CreateUserRequestDTo {


    @NotNull
    String name;

    @Email
    String email;

    @NotBlank
    String address;

    @NotNull
    Integer phoneNumber;

    public UserInfo toUser(){
        return UserInfo.builder()
                .name(this.name)
                .address(this.address)
                .email(this.email)
                .phoneNumber(this.phoneNumber).build();
    }
}
