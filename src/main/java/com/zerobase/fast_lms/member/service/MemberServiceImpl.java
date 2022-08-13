package com.zerobase.fast_lms.member.service;

import com.zerobase.fast_lms.member.entity.Member;
import com.zerobase.fast_lms.member.model.MemberInput;
import com.zerobase.fast_lms.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * 이미 존재하고 있는 아이디는 아닌지 확인필요
     */
    @Override
    public boolean register(MemberInput parameter) {

        Optional<Member> optionalMember = memberRepository.findById(parameter.getUserId());
        if(optionalMember.isPresent()) {    //userId에 해당하는 데이터가 이미 존재하는 경우
            return false;
        }

        Member member = new Member();
        member.setUserId(parameter.getUserId());
        member.setUserName(parameter.getUserName());
        member.setPhone(parameter.getPhone());
        member.setPassword(parameter.getPassword());
        member.setRegDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
