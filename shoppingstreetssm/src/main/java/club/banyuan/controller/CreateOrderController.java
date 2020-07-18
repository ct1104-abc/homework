package club.banyuan.controller;

import club.banyuan.entity.Order;
import club.banyuan.entity.OrderDetail;
import club.banyuan.entity.User;
import club.banyuan.service.OrderService;
import club.banyuan.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CreateOrderController {


    @Autowired
    private OrderService orderService;

    @RequestMapping("/createOrder")
    public String addOrder(HttpSession session) {
        User user = (User) session.getAttribute("user");
        String userAddress = session.getAttribute("userAddress").toString();
        double cost = Double.valueOf(session.getAttribute("cost").toString());

        Order order = new Order();
        order.setId(user.getId());
        order.setUserAddress(userAddress);
        order.setCost(cost);
        List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
        orderService.createOrder(order, orderDetailList);
            return "BuyCar_Three";
    }
}
