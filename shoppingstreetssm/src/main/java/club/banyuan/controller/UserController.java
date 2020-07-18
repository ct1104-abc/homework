package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    public String add(User user){
        userService.add(user);
        System.out.println(user);
        return "index";
    }

    @RequestMapping("/login")
    public String login(HttpSession session,String loginName,String password){
        Map map=new HashMap();
        map.put("loginName",loginName);
        map.put("password",password);
        User user=null;
        user=userService.getLoginUser(map);
        System.out.println(user);
        if(user!=null){
            session.setAttribute("user",user);

        }
        return "index";
    }

}
