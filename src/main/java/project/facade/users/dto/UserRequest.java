package project.facade.users.dto;

import lombok.Data;

@Data
public class UserRequest {
    private  String username;
    private  String email;
    private String phone;
    private String userName;
    private String password;
    private String address;
    private String gender;
    private String birthday;

}
