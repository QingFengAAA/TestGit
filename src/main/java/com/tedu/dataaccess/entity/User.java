package com.tedu.dataaccess.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor


@Table(name="users")// 表名和数据库名不一致无法映射
public class User {

    private int userId;
    private String username;
    private String password;
    private String nickname;
    private String realname;
    private String userImg;
    private String userMobile;
    private String userEmail;
    private String userSex;
    private Date userBirth;
    private Date userRegtime;
    private Date userModtime;

}
