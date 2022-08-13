package com.zerobase.fast_lms.member.controller;

import com.zerobase.fast_lms.member.model.MemberInput;
import com.zerobase.fast_lms.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class MemberController {

    private final MemberService memberService;

    // 회원가입 화면
    @GetMapping("/member/register")
    public String register() {

        return "member/register";
    }

    // 회원가입 정보 입력 후 서버에 전송
    @PostMapping("member/register")
    public String registerSubmit(Model model, HttpServletRequest request, MemberInput parameter) {

        boolean result = memberService.register(parameter);

        model.addAttribute("result", result);

        return "member/register-complete";
    }
}
