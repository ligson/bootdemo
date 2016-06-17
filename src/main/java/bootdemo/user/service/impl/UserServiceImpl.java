package bootdemo.user.service.impl;

import bootdemo.user.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import bootdemo.user.domain.User;
import bootdemo.user.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by trq on 2016/6/16.
 */
@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(user1 -> users.add(user1));
        return users;
    }

    @Override
    public User register(String name, String password, Boolean sex) {
        User user = new User();
        user.setName(name);
        user.setCreateDate(new Date());
        user.setSex(sex);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        userRepository.save(user);
        return user;
    }
}
