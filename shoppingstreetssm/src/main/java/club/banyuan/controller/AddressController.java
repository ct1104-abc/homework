package club.banyuan.controller;

import club.banyuan.entity.Address;
import club.banyuan.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressService addressService;

    @RequestMapping("/address")
    public String Address(HttpSession session){

        Integer id = (Integer) session.getAttribute("addressUid");
        System.out.println(id);

        List<Address> address=new ArrayList<Address>();

            address=addressService.getAddressByID(id);
            session.setAttribute("address",address);
            for(Address address1:address)
                System.out.println(address1);


        return "member_address";
    }
}
