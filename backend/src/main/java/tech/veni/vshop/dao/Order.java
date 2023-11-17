package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    String oid;
    String uid;
    String itemId;
    Double sum;
    Integer count;
    String recipient;
    String address;
    String phoneNumber;
    Timestamp createTime;
}
