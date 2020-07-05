package work.ccpw.contraller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import work.ccpw.domain.User;
import work.ccpw.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @program: Spring
 * @description:
 * @author: Andy
 * @create: 2020-07-04 14:38
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    @ResponseBody
    public List<User> userList() {
        String userJson = "";
        List<User> userList = userService.list();

        return userList;
    }

    @RequestMapping("/save")
    public String save(User user, Long[] roleIds) {

        userService.save(user, roleIds);
        return "user-list";
    }
    @RequestMapping("/del/{userId}")
    public String del(@PathVariable String userId){
        userService.del(userId);

        return "redirect:/pages/user-list.jsp";
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username,password);
        if (user != null){
            // 登录成功 将user存储到session
            session.setAttribute("user",user);
            return "redirect:/index.jsp";
        }
        return "redirect:/login.jsp";
    }
}
