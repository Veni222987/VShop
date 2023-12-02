package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String uid;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String gender;
    private Timestamp createTime;
}
