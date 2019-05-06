package com.qdu.controller;


import com.qdu.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AgencyController {
    @Autowired
    private AgencyService agencyService;
//    @RequestMapping
//    public String agencyAll(Model model){
//         List agencyAll=  agencyService.agencyAll();
//         model.addAttribute("agencyAll",agencyAll);
//        return "agencyAll";
//    }
}
