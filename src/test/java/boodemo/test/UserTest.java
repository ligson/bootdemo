package boodemo.test;

import bootdemo.main.Bootstrap;
import bootdemo.user.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by trq on 2016/6/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Bootstrap.class})
public class UserTest {
    @Autowired
    private UserService userService;

    @Test
    public void registerTest() {
        System.out.println("====================+++");
        assert userService != null;
        for (int i = 0; i < 100; i++) {
            userService.register("user" + i, "password", i % 2 == 0);
        }

    }
}
