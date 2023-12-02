package tech.veni.vshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import tech.veni.vshop.dao.mapper.GoodsMapper;
import tech.veni.vshop.dao.mapper.UserMapper;

@SpringBootTest
public class VshopApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Autowired
    GoodsMapper goodsMapper;

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

//    @Test
//    public void Test() {
//        List<Res2Goods> res = goodsMapper.selectByPage(0, 5);
//        System.out.println(res);
//    }

}
