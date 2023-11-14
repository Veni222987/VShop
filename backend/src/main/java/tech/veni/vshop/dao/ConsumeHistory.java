package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsumeHistory {
    Long id;
    String oid;
    String uid;
    String itemId;
    Integer count;
    Integer sum;
    String recipient;
    String address;
    String phoneNumber;
    Timestamp createTime;
}
