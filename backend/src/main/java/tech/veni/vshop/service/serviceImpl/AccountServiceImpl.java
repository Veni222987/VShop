package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.veni.vshop.dao.Shop;
import tech.veni.vshop.dao.User;
import tech.veni.vshop.dao.mapper.ShopMapper;
import tech.veni.vshop.dao.mapper.UserMapper;
import tech.veni.vshop.service.AccountService;
import tech.veni.vshop.utils.IdUtils;
import tech.veni.vshop.utils.PasswordUtil;

import java.sql.Timestamp;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    ShopMapper shopMapper;

    @Override
    public String userRegister(User user) {
        User tempUser = userMapper.selectByEmail(user.getEmail());
        // 账号存在，返回null
        if (tempUser != null) {
            return null;
        }
        // 生成用户
        user.setUid(IdUtils.generateUid().toString());
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        user.setPassword(PasswordUtil.encryptPassword(user.getPassword()));
        userMapper.insert(user);
        return user.getUid();
    }

    @Override
    public User userLogin(String email, String password) {
        User u = userMapper.selectByEmail(email);
        if (u == null) {
            return null;
        }
        if (PasswordUtil.verifyPassword(password, u.getPassword())) {
            return u;
        } else
            return new User(-1, null, null, null, "密码错误", null, null, null);
    }

    @Override
    public String shopRegister(Shop shop) {
        Shop tempShop = shopMapper.selectByEmail(shop.getEmail());
        // 账号存在，返回null
        if (tempShop != null) {
            return null;
        }
        // 生成商家
        shop.setSid(IdUtils.generateUid().toString());
        shop.setCreateTime(new Timestamp(System.currentTimeMillis()));
        shop.setPassword(PasswordUtil.encryptPassword(shop.getPassword()));
        shopMapper.insert(shop);
        return shop.getSid();
    }

    @Override
    public Shop shopLogin(String email, String password) {
        Shop s = shopMapper.selectByEmail(email);
        if (s == null) {
            return null;
        }
        if (PasswordUtil.verifyPassword(password, s.getPassword())) {
            return s;
        } else
            return new Shop(-1, null, null, null, null, null);
    }

}
