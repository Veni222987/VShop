package tech.veni.vshop.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tech.veni.vshop.dao.User;
import tech.veni.vshop.dao.mapper.UserMapper;
import tech.veni.vshop.service.UserService;
import tech.veni.vshop.utils.IdUtils;
import tech.veni.vshop.utils.JwtUtil;
import tech.veni.vshop.utils.PasswordUtil;
import tech.veni.vshop.vo.Req4Login;
import tech.veni.vshop.vo.Req4Register;

import java.sql.Timestamp;
import java.time.Duration;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public String register(Req4Register req4Register) {
        //检测账号是否已经存在
        if (userMapper.selectByPhoneNumber(req4Register.getPhoneNumber()) != null) {
            return null;
        }
        //生成用户
        User user = new User(req4Register);
        user.setPassword(PasswordUtil.encryptPassword(req4Register.getPassword()));
        user.setUid(IdUtils.generateUid().toString());
        user.setCreateTime(new Timestamp(System.currentTimeMillis()));
        userMapper.insert(user);
        //生成token
        String token = JwtUtil.generateJwt(user.getUid());
        Duration expiration = Duration.ofSeconds(60 * 60 * 24); // 设置过期时间为 24 小时
        redisTemplate.opsForValue().set(user.getUid(), token, expiration);
        return token;
    }

    public String login(Req4Login req4UserLogin) {
        //检测账号密码
        User user = userMapper.selectByPhoneNumber(req4UserLogin.getPhoneNumber());
        if (!PasswordUtil.verifyPassword(req4UserLogin.getPassword(), user.getPassword())) {
            return null;
        }
        //生成token
        if (Boolean.TRUE.equals(redisTemplate.hasKey(user.getUid()))) {
            //刷新token有效期
            redisTemplate.expire(user.getUid(), Duration.ofSeconds(60 * 60 * 24));
            return (String) redisTemplate.opsForValue().get(user.getUid());
        } else {
            String token = JwtUtil.generateJwt(user.getUid());
            redisTemplate.opsForValue().set(user.getUid(), token);
            return token;
        }
    }
}
