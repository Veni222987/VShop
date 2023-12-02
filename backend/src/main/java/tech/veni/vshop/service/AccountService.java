package tech.veni.vshop.service;

import tech.veni.vshop.dao.Shop;
import tech.veni.vshop.dao.User;

public interface AccountService {
    /**
     * 用户注册
     *
     * @param user 用户信息
     */
    String userRegister(User user);

    /**
     * 用户登录
     *
     * @param email    邮箱
     * @param password 密码
     * @return token
     */
    String userLogin(String email, String password);

    /**
     * 商家注册
     *
     * @param shop 商家信息
     */
    String shopRegister(Shop shop);

    /**
     * 商家登录
     *
     * @param email    邮箱
     * @param password 密码
     */
    String shopLogin(String email, String password);

}
