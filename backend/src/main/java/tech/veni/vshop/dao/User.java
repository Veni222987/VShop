package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
