package com.blog.api.controller;

import com.blog.api.dto.MemberLoginRequest;
import com.blog.api.dto.MemberSignUpRequest;
import com.blog.api.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "회원정보")
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/member")
@RestController
public class MemberController {
  private final MemberService memberService;

  @Operation(summary = "회원가입")
  @PostMapping("/signUp")
  public ResponseEntity<Object> signUp(@RequestBody MemberSignUpRequest memberSignUpRequest) {
    try {
      memberService.signUp(memberSignUpRequest);
    } catch (RuntimeException re) {
      log.error("err:", re);
      return ResponseEntity.badRequest().body(re.getMessage());
    } catch (Exception e) {
      log.error("err:", e);
      return ResponseEntity.badRequest().body("알 수 없는 error");
    }
    return ResponseEntity.ok().body("success");
  }

  @Operation(summary = "로그인")
  @PostMapping("/login")
  public ResponseEntity<Object> login(@RequestBody MemberLoginRequest memberLoginRequest) {
    try {
      memberService.login(memberLoginRequest);
    } catch (RuntimeException re) {
      log.error("err:", re);
      return ResponseEntity.badRequest().body(re.getMessage());
    } catch (Exception e) {
      log.error("err:", e);
      return ResponseEntity.badRequest().body("알 수 없는 error");
    }
    return ResponseEntity.ok().body("success");
  }

  @Operation(summary = "회원정보")
  @GetMapping("info")
  public ResponseEntity<Object> info(@RequestParam String username) {
    Object data = null;
    try {
      data = memberService.memberInfo(username);
    } catch (RuntimeException re) {
      log.error("err:", re);
      return ResponseEntity.badRequest().body(re.getMessage());
    } catch (Exception e) {
      log.error("err:", e);
      return ResponseEntity.badRequest().body("알 수 없는 error");
    }
    return ResponseEntity.ok().body(data);
  }
}
