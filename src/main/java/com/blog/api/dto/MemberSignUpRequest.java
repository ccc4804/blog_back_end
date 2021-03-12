package com.blog.api.dto;

import lombok.Data;

@Data
public class MemberSignUpRequest {
    private String username;
    private String password;
    private String email;
}
