package club.banyuan.controller;

import club.banyuan.entity.Address;
import club.banyuan.entity.Product;
import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ConfirmOrderController {
    @Autowired
    private UserService userService;

    @RequestMapping("/confirmOrder")
    public String ConfirmOrder(HttpSession session) {
        if (session.getAttribute("user") == null) {
            return "login";
        }
        //判断购物车、计算总价、查询用户地址
        Map<Product, Integer> cart = (Map<Product, Integer>) session.getAttribute("cart");
        double cost = 0;
        for (Product product : cart.keySet()) {
            cost += product.getPrice() * cart.get(product);
            System.out.println("coust:"+cost);
        }
        session.setAttribute("cost", cost);
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        System.out.println(user.getId());
        String userAddress = userService.getDefaultAddress(user.getId());
        System.out.println(userAddress);
        session.setAttribute("userAddress", userAddress);

        return "BuyCar_Two";
    }
}
