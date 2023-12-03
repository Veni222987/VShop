package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.veni.vshop.dao.Cart;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req4Settle {
    String uid;
    List<Cart> carts;
    Integer addressId;
}
