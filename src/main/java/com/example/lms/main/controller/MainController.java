package com.example.lms.main.controller;

import com.example.lms.banner.dto.BannerDto;
import com.example.lms.banner.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final BannerService bannerService;

    @RequestMapping("/")
    public String index(Model model) {
        List<BannerDto> bannerList = bannerService.listAll();
        List<BannerDto> list = new ArrayList<>();

        for (BannerDto x : bannerList) {
            if (x.isOpenYn()) {
                list.add(x);
            }
        }

        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping("/error/denied")
    public String errorDenied() {

        return "error/denied";
    }
}
