package tech.veni.vshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.service.UserService;
import tech.veni.vshop.vo.Req4Login;
import tech.veni.vshop.vo.Req4Register;

import java.util.HashMap;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 注册接口
     */
    @PostMapping("/register")
    public HashMap<String, Object> register(@RequestBody Req4Register req4Register) {
        HashMap<String, Object> data = new HashMap<>();
        String token = userService.register(req4Register);
        if (!ObjectUtils.isEmpty(token)) {
            data.put("code", 200);
            data.put("msg", "注册成功");
            data.put("token", token);
        } else {
            data.put("code", 400);
            data.put("msg", "用户已存在");
        }
        return data;
    }

    /**
     * 登录接口
     */
    @GetMapping("/login")
    public HashMap<String, Object> login(@RequestParam("account") String phoneNumber,
                                         @RequestParam("password") String password) {
        HashMap<String, Object> data = new HashMap<>();
        Req4Login req4Login = new Req4Login(null, phoneNumber, password);
        String token = userService.login(req4Login);
        if (!ObjectUtils.isEmpty(token)) {
            data.put("code", 200);
            data.put("msg", "登录成功");
            data.put("token", token);
        } else {
            data.put("code", 400);
            data.put("msg", "登录失败");
        }
        return data;
    }
}
