package com.example.meltingpop.controller;

import com.example.meltingpop.dto.UserDto;
import com.example.meltingpop.entity.User;
import com.example.meltingpop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class LoginController {
    private UserService userService;
    public LoginController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(value="/login")
    public Map<String, Object> login1(UserDto userDto){

        Map<String, Object> result = new HashMap<String, Object>();
        System.out.println(userDto.getUserEmail());
        System.out.println(userDto.getUserPw());

        User userInDB = userService.login(userDto.getUserEmail(), userDto.getUserPw());

        if(userInDB!=null&&userInDB.getUserAuthentication()==0){
            result.put("code","회원 로그인 성공");
            System.out.println("회원 로그인 성공");
        }

        else if(userInDB!=null&&userInDB.getUserAuthentication()==1){
            result.put("code","관리자 로그인 성공");
            System.out.println("관리자 로그인 성공");
        }

        else {
            result.put("code", "로그인실패");
            System.out.println("로그인실패");
        }
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
