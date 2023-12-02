package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.vo.Req4ShopRegister;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Shop {
    Integer id;
    String sid;
    String name;
    String email;
    String password;
    Timestamp createTime;

    public Shop(Req4ShopRegister req) {
        this.name = req.getName();
        this.email = req.getEmail();
        this.password = req.getPassword();
    }
}
