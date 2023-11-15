package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.vo.Req4Register;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String uid;
    private String username;
    private String password;
    private String avatar;
    private String gender;
    private String phoneNumber;
    private Timestamp createTime;

    public User(Req4Register req4Register) {
        this.username = req4Register.getUsername();
        this.password = req4Register.getPassword();
        this.avatar = req4Register.getAvatar();
        this.gender = req4Register.getGender();
        this.phoneNumber = req4Register.getPhoneNumber();
    }
}
