package com.zerobase.fast_lms;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class MainController {

    @RequestMapping("/")
    public String index() {

        return "index";
    }

    // request: 웹 브라우저 -> 서버
    // response: 서버 -> 웹 브라우저
    @RequestMapping("/hello")
    public void hello(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw = response.getWriter();

        String msg = "<html>" +
                "<head>" +
                "<meta charset = \"UTF-8\">" +
                "</head>" +
                "<body>" +
                "<p>hello</p>" +
                "<p>fast_lms website!!</p>" +
                "<p>안녕하세요!!! ===> </p>" +
                "</body>" +
                "</html>";

        pw.write(msg);
        pw.close();
    }
}
