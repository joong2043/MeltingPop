package com.example.meltingpop.controller;

import com.example.meltingpop.dto.UserDto;
import com.example.meltingpop.entity.User;
import com.example.meltingpop.service.UserService;
import com.example.meltingpop.session.SessionConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.example.meltingpop.session.SessionConst.LOGIN_USER;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class LoginController {
    private UserService userService;
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value="/login")
    public Map<String, Object> login1(User user, HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPw());

        User loginUser = userService.login(user.getUserEmail(), user.getUserPw());

        if(loginUser==null){
            result.put("code","로그인 실패");
            System.out.println("로그인 실패");
            return result;
        }

        // 세션 매니저를 이용하여 세션 생성과 회원정보를 보관한다.
        // 세션이 있으면 있는 세션을 반환하고, 세션이 없다면 신규 세션을 만들어준다.
        HttpSession session = request.getSession();
        session.setAttribute(LOGIN_USER, loginUser);

        if(loginUser.getUserAuthentication()==0){
            result.put("code","회원 로그인 성공");
            System.out.println("회원 로그인 성공");
            System.out.println("세션 확인: "+session.getAttribute(LOGIN_USER));
            //LOGIN_USER로 바인딩 된 객체를 가져온다.

        }

        else if(loginUser.getUserAuthentication()==1){
            result.put("code","관리자 로그인 성공");
            System.out.println("관리자 로그인 성공");
            System.out.println("세션 확인: "+session.getAttribute(LOGIN_USER));
            //LOGIN_USER로 바인딩 된 객체를 가져온다.
        }
        System.out.println("세션 재확인: "+session.getAttribute(LOGIN_USER));

        return result;
    }

    // 프론트(메인 페이지)에서 로그인 버튼 누르면 /login으로 넘어가도록 설정
//    @PostMapping("/login")
//    public String login(User user){
//        User userInDB = userService.login(user.getUserId(), user.getUserPw());
//        if(userInDB == null){
//            System.out.println("다시 입력해주세요");
//            return "redirect:/";
//        }
//        return "static/index";
//    }
}
