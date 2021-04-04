package com.denglitong.mybatisplus;

import com.denglitong.mybatisplus.quickstart.entity.User;
import com.denglitong.mybatisplus.quickstart.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author denglitong
 * @date 2021/4/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class TableLogicTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void testDelete() {
        Assertions.assertTrue(userMapper.deleteById(2) > 0);
    }

    @Test
    void testSelect() {
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(0, userList.size());

        User user = new User();
        user.setName("yinli");
        user.setAge(17);
        user.setEmail("yinli@example.com");

        Assertions.assertTrue(userMapper.insert(user) > 0);
        userList = userMapper.selectList(null);
        Assertions.assertEquals(1, userList.size());
    }
}
