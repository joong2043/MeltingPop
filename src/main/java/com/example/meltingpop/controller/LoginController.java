package com.example.meltingpop.controller;

import com.example.meltingpop.entity.User;
import com.example.meltingpop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    private UserService userService;
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value="/login")
    public String login(){
        return "templates/user/login";
    }

    // 프론트(메인 페이지)에서 로그인 버튼 누르면 /login으로 넘어가도록 설정
    @PostMapping("/login")
    public String login(User user){
        User userInDB = userService.login(user.getUserId(), user.getUserPw());
        if(userInDB == null){
            System.out.println("다시 입력해주세요");
            return "redirect:/";
        }
        return "static/index";
    }
}
