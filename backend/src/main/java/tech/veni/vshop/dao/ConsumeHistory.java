package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumeHistory {
    Integer id;
    String orderId;
    String uid;
    String goodsId;
    Integer count;
    Double sum;
    Integer addressId;
    Timestamp createTime;
}
