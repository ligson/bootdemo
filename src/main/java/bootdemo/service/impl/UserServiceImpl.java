package bootdemo.service.impl;

import bootdemo.dao.UserDao;
import org.springframework.stereotype.Component;
import bootdemo.domain.User;
import bootdemo.service.UserService;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by trq on 2016/6/16.
 */
@Component("userService")
public class UserServiceImpl implements UserService {
  //  @Resource
//    private UserDao userDao;

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
  //      userDao.findAll().forEach(user1 -> users.add(user1));
        return users;
    }

    @Override
    public User register(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
       // userDao.save(user);
        return user;
    }
}
