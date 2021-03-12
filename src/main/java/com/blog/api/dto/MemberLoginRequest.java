package com.blog.api.dto;

import lombok.Data;

@Data
public class MemberLoginRequest {
  private String username;
  private String password;
}
