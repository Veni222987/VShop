package tech.veni.vshop.service;

import tech.veni.vshop.vo.Req4Login;
import tech.veni.vshop.vo.Req4Register;

public interface UserService {

    /**
     * 用户注册
     *
     * @param req4Register
     * @return String:null表示注册失败，否则返回token
     */
    String register(Req4Register req4Register);


    /**
     * 用户登录
     *
     * @param req4UserLogin
     * @return String:null表示登录失败，否则返回token
     */
    String login(Req4Login req4UserLogin);
}
