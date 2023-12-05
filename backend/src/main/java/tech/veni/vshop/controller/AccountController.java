package tech.veni.vshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.veni.vshop.dao.Shop;
import tech.veni.vshop.dao.User;
import tech.veni.vshop.service.AccountService;
import tech.veni.vshop.vo.BaseRes;
import tech.veni.vshop.vo.Req4Login;
import tech.veni.vshop.vo.Req4Register;
import tech.veni.vshop.vo.Req4ShopRegister;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    AccountService accountService;

    /**
     * 用户注册接口
     */
    @PostMapping("/user/register")
    public BaseRes register(@RequestBody Req4Register req4Register) {
        BaseRes res = new BaseRes();
        User u = new User(req4Register);
        String uid = accountService.userRegister(u);
        if (uid == null) {
            res.setCode(400);
            res.setMsg("账号已存在");
            return res;
        }
        res.setCode(200);
        res.setData(uid);
        return res;
    }

    /**
     * 登录接口
     */
    @PostMapping("/user/login")
    public BaseRes login(@RequestBody Req4Login req4Login) {
        BaseRes res = new BaseRes();
        User user = accountService.userLogin(req4Login.getEmail(), req4Login.getPassword());
        if (user == null) {
            res.setCode(400);
            res.setMsg("账号不存在");
            return res;
        } else if (user.getId() == -1) {
            res.setCode(400);
            res.setMsg("密码错误");
            return res;
        } else {
            res.setCode(200);
            res.setData(user);
            return res;
        }
    }

    /**
     * 商家注册接口
     */
    @PostMapping("/seller/register")
    public BaseRes shopRegister(@RequestBody Req4ShopRegister req4ShopRegister) {
        BaseRes res = new BaseRes();
        Shop s = new Shop(req4ShopRegister);
        String sid = accountService.shopRegister(s);
        if (sid == null) {
            res.setCode(400);
            res.setMsg("账号已存在");
            return res;
        }
        res.setCode(200);
        res.setData(sid);
        return res;
    }

    /**
     * 商家登录接口
     */

    @PostMapping("/seller/login")
    public BaseRes shopLogin(@RequestBody Req4Login req4Login) {
        BaseRes res = new BaseRes();
        Shop shop = accountService.shopLogin(req4Login.getEmail(), req4Login.getPassword());
        if (shop == null) {
            res.setCode(400);
            res.setMsg("账号不存在");
            return res;
        } else if (shop.getId() == -1) {
            res.setCode(400);
            res.setMsg("密码错误");
            return res;
        } else {
            res.setCode(200);
            res.setData(shop);
            return res;
        }
    }
}
