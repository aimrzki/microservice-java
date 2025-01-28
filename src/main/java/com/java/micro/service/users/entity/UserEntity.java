package com.java.micro.service.users.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "users")
public class UserEntity {
    private String userId;
    private String email;
    private String phone;
    private String userName;
    private String password;
    private String address;
    private String gender;
    private String birthday;
}
