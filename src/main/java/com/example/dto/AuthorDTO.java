package com.example.dto;

import lombok.Data;

@Data
public class AuthorDTO {
    private Integer id;
    private String username;
    private String password;
    private String email;

    public AuthorDTO() {
    }

    public AuthorDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
