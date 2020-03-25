package com.chaiyc.springboot.controller.subway;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SubwayController {

    @GetMapping("/subway/list")
    public String list(Model model){

        return "subway/subway_list";
    }
}
