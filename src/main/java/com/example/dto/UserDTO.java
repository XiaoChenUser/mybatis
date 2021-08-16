package com.example.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class UserDTO {
    private Integer id;
    private String username;
    private String password;
    private Date createTime;


}
