package com.myHotel.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/staffHome")
    public String showStaffHomePage(){
        return "staffHome";
    }

    @RequestMapping("/reserveHome")
    public String showReserve(){
        return "reservation";
    }

}
