package com.jack.cache.bean;


import lombok.Getter;
import lombok.Setter;
import java.util.Date;

/**
 * @author PC20
 * @create 2019/8/1
 */
public class User {

    @Getter @Setter private Integer id;//ID

    @Getter @Setter private String lastName;//用户昵称

    @Getter @Setter private String IdCode;//用户编码

    @Getter @Setter private String password;//密码

    @Getter @Setter private String email;//用户邮箱

    @Getter @Setter private Date createTime;//注册时间

    @Getter @Setter private String headPortrait;//头像

    @Getter @Setter private Date lastLogin=new Date();//最后登录


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", IdCode='" + IdCode + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createTime=" + createTime +
                ", headPortrait='" + headPortrait + '\'' +
                ", lastLogin=" + lastLogin +
                '}';
    }

    public User() {
    }

}
