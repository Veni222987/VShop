package tech.veni.vshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import tech.veni.vshop.dao.mapper.UserMapper;

import java.util.HashMap;

@SpringBootTest
public class VshopApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Autowired
    RedisTemplate<String, Object> redisTemplate;

//    @Test
//    public void UserMapperTest() {
//        User u = new User(0L, "test", "test", "test", "test", "test", "test", new Timestamp(0));
//        System.out.println(u);
//        userMapper.insert(u);
//    }
//
//    @Test
//    public void RedisTest() {
//        redisTemplate.opsForValue().set("hellotest", "test");
//        System.out.println(redisTemplate.opsForValue().get("hellotest"));
//    }

    @Test
    public void Test() {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 2);
        map.put(2, 1);
        System.out.println(map);
    }

}
