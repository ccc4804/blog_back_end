package com.blog.api.service;

import com.blog.api.dto.MemberLoginRequest;
import com.blog.api.dto.MemberSignUpRequest;
import com.blog.api.entity.Member;
import com.blog.api.repositoy.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class MemberServiceImpl implements MemberService {
  private final MemberRepository memberRepository;
  private final ModelMapper modelMapper;
  private final PasswordEncoder passwordEncoder;

  @Override
  public void signUp(MemberSignUpRequest memberSignUpRequest) {
    Optional<Member> optionalMember =
        memberRepository.findByUsername(memberSignUpRequest.getUsername());

    if (optionalMember.isPresent()) {
      throw new RuntimeException("존재하는 아이디입니다.");
    }

    Member member = modelMapper.map(memberSignUpRequest, Member.class);
    member.setPassword(passwordEncoder.encode(member.getPassword()));

    memberRepository.save(member);
  }

  @Override
  public boolean login(MemberLoginRequest memberLoginRequest) {

    Optional<Member> optionalMember =
        memberRepository.findByUsername(memberLoginRequest.getUsername());

    if (!optionalMember.isPresent()) {
      throw new RuntimeException("존재하지 않는 아이디입니다.");
    }

    Member member = optionalMember.get();

    if (!passwordEncoder.matches(memberLoginRequest.getPassword(), member.getPassword())) {
      throw new RuntimeException("비밀번호가 틀립니다.");
    }

    return true;
  }

  @Override
  public Member memberInfo(String username) {
    Optional<Member> optionalMember = memberRepository.findByUsername(username);

    if (!optionalMember.isPresent()) {
      throw new RuntimeException("존재하지 않는 아이디입니다.");
    }

    return optionalMember.get();
  }
}
