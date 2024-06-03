package com.ap.crud.samnple.ReactCrudApp.dto;

import lombok.Data;

@Data
public class LoginDto {

    private String email;

    private String password;

    @Override
    public String toString() {
        return "LoginDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
