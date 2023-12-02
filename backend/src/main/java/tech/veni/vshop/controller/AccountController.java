package tech.veni.vshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veni.vshop.service.UserService;
import tech.veni.vshop.vo.BaseRes;
import tech.veni.vshop.vo.Req4Login;
import tech.veni.vshop.vo.Req4Register;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    UserService userService;

    /**
     * 用户注册接口
     */
    @PostMapping("/user/register")
    public BaseRes register(@RequestBody Req4Register req4Register) {
        BaseRes res = new BaseRes();
        // TODO 用户注册
        return res;
    }

    /**
     * 登录接口
     */
    @PostMapping("/user/login")
    public BaseRes login(@RequestBody Req4Login req4Login) {
        BaseRes res = new BaseRes();
        // TODO 用户登录
        return res;
    }

    /**
     * 商家注册接口
     */
    @PostMapping("/seller/register")
    public BaseRes shopRegister(@RequestBody Req4Register req4Register) {
        BaseRes res = new BaseRes();
        // TODO 商家注册
        return res;
    }

    /**
     * 商家登录接口
     */

    @PostMapping("/seller/login")
    public BaseRes shopLogin(@RequestBody Req4Login req4Login) {
        BaseRes res = new BaseRes();
        // TODO 商家登录
        return res;
    }
}
