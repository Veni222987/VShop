package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Shop {
    Integer id;
    String sid;
    String name;
    String email;
    String password;
    String createTime;
}
