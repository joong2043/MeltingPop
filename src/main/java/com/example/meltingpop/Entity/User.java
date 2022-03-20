package com.example.meltingpop.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// 데이터베이스에 연결하여 테이블 생성을 위해 필요한 클래스
// 밑에 @Column을 붙여서 만들고 싶은 속성을 명시하면 된다.
// @Entity는 JPA가 관리하는 클래스로, 해당 클래스를 엔티티라고 한다.
//
@Entity
@Getter
@Setter
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserNum;

    @Column
    private String UserId;

    @Column
    private String UserPw;

    @Column
    private String UserEmail;

}
