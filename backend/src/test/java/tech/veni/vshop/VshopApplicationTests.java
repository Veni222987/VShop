package tech.veni.vshop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.veni.vshop.dao.User;
import tech.veni.vshop.dao.mapper.UserMapper;

import java.sql.Timestamp;

@SpringBootTest
public class VshopApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    public void UserMapperTest() {
        User u = new User(0L, "test", "test", "test", "test", "test", "test", new Timestamp(0));
        System.out.println(u);
        userMapper.insert(u);
    }

}
