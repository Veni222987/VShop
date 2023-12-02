package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req4ShopRegister {
    String name;
    String email;
    String password;
}
