package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    Long id;
    String uid;
    String itemId;
    Integer count;
    Integer sum;
}
