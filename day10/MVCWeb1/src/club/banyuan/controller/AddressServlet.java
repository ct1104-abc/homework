package club.banyuan.controller;

import club.banyuan.entity.Address;
import club.banyuan.entity.User;
import club.banyuan.service.AddressService;
import club.banyuan.service.impl.AddressServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sound.midi.Soundbank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddressServlet",urlPatterns = "/address.do")
public class AddressServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Integer id = (Integer) session.getAttribute("addressUid");
        System.out.println(id);
        AddressService addressService=new AddressServiceImpl();
        List<Address> address=new ArrayList<>();
        try {
            address=addressService.getAddressByID(id);
            session.setAttribute("address",address);
            for(Address address1:address)
                System.out.println(address1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("member_address.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
