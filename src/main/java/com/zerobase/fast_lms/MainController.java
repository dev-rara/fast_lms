package com.zerobase.fast_lms;

import com.zerobase.fast_lms.component.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final MailComponents mailComponents;

    @RequestMapping("/")
    public String index() {

        String email = "rara_kk@naver.com";
        String subject = "안녕하세요. 제로베이스 입니다.";
        String text = " 안녕하세요. 반갑습니다.";

        mailComponents.sendMail(email, subject, text);

        return "index";
    }
}
