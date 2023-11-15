package tech.veni.vshop.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req4Register {
    private String username;
    private String password;
    private String avatar;
    private String gender;
    private String phoneNumber;
}
