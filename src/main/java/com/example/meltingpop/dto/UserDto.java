package com.example.meltingpop.dto;

import com.example.meltingpop.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long userNum;
    private String userId;
    private String userPw;
    private String userEmail;
    private Integer userAuthentication;
    // 생성자 파라미터를 주입해주기
    public User toEntity(){
        User userBuild = User.builder()
                .userNum(userNum)
                .userId(userId)
                .userPw(userPw)
                .userEmail(userEmail)
                .userAuthentication(userAuthentication)
                .build();
        return userBuild;
    }

    @Builder
    public UserDto(Long userNum,String userId, String userPw, String userEmail, Integer userAuthentication){
        this.userNum = userNum;
        this.userId = userId;
        this.userPw = userPw;
        this.userEmail = userEmail;
        this.userAuthentication = userAuthentication;
    }
}
