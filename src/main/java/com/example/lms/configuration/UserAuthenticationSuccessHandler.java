package com.example.lms.configuration;

import com.example.lms.admin.mapper.MemberMapper;
import com.example.lms.member.model.MemberHistoryInput;
import com.example.lms.member.service.MemberHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.activation.UnknownObjectException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final MemberMapper memberMapper;
    private final MemberHistoryService memberHistoryService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        String userId = authentication.getName();
        memberMapper.updateLastLoginDt(userId, LocalDateTime.now());

        String userAgent = request.getHeader("User-Agent");
        String userIp = "";

        try {
            userIp = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        MemberHistoryInput historyInput = MemberHistoryInput.builder()
                                            .userId(userId)
                                            .loginDt(LocalDateTime.now())
                                            .userIp(userIp)
                                            .userAgent(userAgent)
                                            .build();

        memberHistoryService.saveHistory(historyInput);

        setDefaultTargetUrl("/");
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
