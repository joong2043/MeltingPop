package com.example.meltingpop.dto;

import com.example.meltingpop.entity.User;
import lombok.Builder;

public class UserDto {
    private Long userNum;
    private String userId;
    private String userPw;
    private String userEmail;

    public User toEntity(){
        User build = User.builder()
                .userNum(userNum)
                .userId(userId)
                .userPw(userPw)
                .userEmail(userEmail)
                .build();
        return build;
    }

    @Builder
    public UserDto(Long userNum,String userId, String userPw, String userEmail){
        this.userNum = userNum;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
    }
}
