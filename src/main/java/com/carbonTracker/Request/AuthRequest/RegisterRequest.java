package com.carbonTracker.Request.AuthRequest;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RegisterRequest {

    private String name;
    private String email;
    private String password;
    private String phone;
}
