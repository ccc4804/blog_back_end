package com.blog.api.service;

import com.blog.api.dto.MemberLoginRequest;
import com.blog.api.dto.MemberSignUpRequest;
import com.blog.api.entity.Member;

public interface MemberService {
  void signUp(MemberSignUpRequest memberSignUpRequest);

  boolean login(MemberLoginRequest memberLoginRequest);

  Member memberInfo(String username);
}
