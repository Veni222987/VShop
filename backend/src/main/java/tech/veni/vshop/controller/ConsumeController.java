package tech.veni.vshop.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.veni.vshop.service.ConsumeService;
import tech.veni.vshop.vo.Res2Order;

import java.util.HashMap;

@RestController
@RequestMapping("/api/consume")
public class ConsumeController {
    @Autowired
    private ConsumeService consumeService;

    //清空某人购物车，生成订单
    @PostMapping("/settle")
    public Res2Order settle(@RequestBody String uid) {
        return consumeService.settle(uid);
    }

    //结算订单
    @GetMapping("/pay")
    public HashMap<String, Object> pay(@Param("oid") String oid, @Param("uid") String uid) {
        consumeService.pay(uid, oid);
        HashMap<String, Object> res = new HashMap<>();
        res.put("code", 200);
        res.put("msg", "success");
        return res;
    }
}
