package com.zerobase.fast_lms.member.service.impl;

import com.zerobase.fast_lms.component.MailComponents;
import com.zerobase.fast_lms.member.entity.Member;
import com.zerobase.fast_lms.member.model.MemberInput;
import com.zerobase.fast_lms.member.repository.MemberRepository;
import com.zerobase.fast_lms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final MailComponents mailComponents;

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

        String uuid = UUID.randomUUID().toString();

        Member member = Member.builder()
                .userId(parameter.getUserId())
                .userName(parameter.getUserName())
                .phone(parameter.getPhone())
                .password(parameter.getPassword())
                .regDt(LocalDateTime.now())
                .emailAuthYn(false)
                .emailAuthKey(uuid)
                .build();


        String email = parameter.getUserId();
        String subject = "lms 사이트 가입을 축하드립니다. ";
        String text = "<p>lms 사이트 가입을 축하드립니다.</p>"
                + "<p>아래 링크를 클릭하셔서 가입을 완료 하세요.</p>"
                + "<div><a target='_blank' href='http://localhost:8080/member/email-auth?id="
                + uuid + "'> 가입 완료 </a></div>";
        mailComponents.sendMail(email, subject, text);

        return true;
    }

    @Override
    public boolean emailAuth(String uuid) {

        Optional<Member> optionalMember = memberRepository.findByEmailAuthKey(uuid);

        if(!optionalMember.isPresent()) {
            return false;
        }
        Member member = optionalMember.get();
        member.setEmailAuthYn(true);
        member.setEmailAuthDt(LocalDateTime.now());
        memberRepository.save(member);

        return true;
    }
}
