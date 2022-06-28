package com.example.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TokenDTO {
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;
    private String token;

    public TokenDTO(Date loginTime, String token){
        this.loginTime = loginTime;
        this.token = token;
    }
}
