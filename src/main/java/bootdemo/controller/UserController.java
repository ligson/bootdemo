package bootdemo.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.ResponseBody;
        import bootdemo.domain.User;
        import bootdemo.service.UserService;

        import javax.annotation.Resource;
        import java.util.List;

/**
 * Created by trq on 2016/6/16.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping("/list.json")
    @ResponseBody
    List<User> list() {
        return userService.list();
    }

    @RequestMapping("/register.do")
    @ResponseBody
    User register(String name, String password) {
        return userService.register(name, password);
    }
}
