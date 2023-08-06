package com.example.online_shop.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/customer/list")
    public String customerList(Model model){
        List<Customer> cList = customerService.getCList();
        model.addAttribute("customerList",cList);
        return "customerlist";
    }

    @PostMapping("/customer/create")
    public String customer_register(@RequestParam String name, @RequestParam String birth) throws ParseException {
//        Customer customer = customerService.getCustomer(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        java.util.Date utilDate = sdf.parse(birth);
        Date birthday = new Date(utilDate.getTime());
        customerService.insertCustomer(name,birthday);
        return "redirect:/customer/list";
    }
    @GetMapping("/")
    public String root(){
        return "redirect:/customer/list";
    }

}
