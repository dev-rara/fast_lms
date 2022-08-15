package com.zerobase.fast_lms.main.controller;

import com.zerobase.fast_lms.component.MailComponents;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }
}
