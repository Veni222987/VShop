package tech.veni.vshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.service.UserService;
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
        if (!ObjectUtils.isEmpty(userService.register(req4Register))) {
            data.put("code", 200);
            data.put("msg", "注册成功");
        } else {
            data.put("code", 400);
            data.put("msg", "注册失败");
        }
        return data;
    }

    /**
     * 登录接口
     */
//    @GetMapping("/login")
//    public HashMap<String, Object> login(HttpServletRequest req, HttpServletResponse res) {
//        HashMap<String, Object> data = new HashMap<>();
//        Req4Login req4Login = new Req4Login(null, req.getParameter("phoneNumber"), req.getParameter("password"));
//        if (userService.login(req4Login) != null) {
//            data.put("code", 200);
//            data.put("msg", "登录成功");
//        } else {
//            data.put("code", 400);
//            data.put("msg", "登录失败");
//        }
//        return data;
//    }
    @GetMapping("/test")
    public HashMap<String, Object> test() {
        HashMap<String, Object> data = new HashMap<>();
        data.put("code", 200);
        data.put("msg", "测试成功");
        return data;
    }
}
