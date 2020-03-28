package com.chaiyc.springboot.controller.subway;

import com.chaiyc.springboot.entities.subway.Subway;
import com.chaiyc.springboot.service.subway.SubwayService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/subway")
public class SubwayController {

    @Autowired
    SubwayService subwayService;

    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(name = "pageNum", defaultValue = "1") int pageNo,
                       @RequestParam(name = "page.size",defaultValue = "8") int pageSize){

        PageInfo<Subway> pageInfo = subwayService.getPageSubway(pageNo,pageSize);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("url","/subway/list");
        return "subway/subway_list";
    }

    @GetMapping("/query")
    public String query(Model model,
                       @RequestParam(name = "pageNum", defaultValue = "1") int pageNo,
                       @RequestParam(name = "page.size",defaultValue = "8") int pageSize){

        PageInfo<Subway> pageInfo = subwayService.getPageSubway(pageNo,pageSize);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("url","/subway/list");
        return "subway/subway_query";
    }


}
