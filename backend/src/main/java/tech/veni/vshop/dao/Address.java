package tech.veni.vshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    Integer id;
    String uid;
    String addressName;
    String address;
    String receiver;
    String phoneNumber;
    String email;
}
