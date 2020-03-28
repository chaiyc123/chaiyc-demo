package com.chaiyc.springboot.controller.subway;

import com.chaiyc.springboot.entities.subway.Subway;
import com.chaiyc.springboot.service.subway.SubwayService;
import com.chaiyc.springboot.utils.DateUtil;
import com.chaiyc.springboot.utils.StringUtil;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
    public String query(Model model,Subway subway,
                       @RequestParam(name = "pageNum", defaultValue = "1") int pageNo,
                       @RequestParam(name = "page.size",defaultValue = "8") int pageSize,
                        HttpServletRequest request, HttpServletResponse response){


        PageInfo<Subway> pageInfo = subwayService.getQueryPageSubway(pageNo,pageSize,subway);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("subway",subway);
        model.addAttribute("url","/subway/query");
        return "subway/subway_query";
    }

    @RequestMapping("/edit")
    public String edit(String dataId, Model model, HttpServletRequest request,
                       HttpServletResponse response) throws Exception{

        if(StringUtil.isNotEmpty(dataId)){
            Subway subway = subwayService.getSubwayById(dataId);
            model.addAttribute("subway",subway);
        }
        return "subway/subway_edit";
    }

    @RequestMapping("/save")
    public String save(Subway subway){

        if(StringUtil.isNotEmpty(subway.getDataId())){
            subwayService.updateUser(subway);
        }else{
            //设置时间
            subway.setCreateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
            subwayService.saveSubway(subway);
        }
        return "redirect:/subway/list";
    }

    /**
     * 删除用户
     */
    @RequestMapping("/delete")
    public String delete(String dataId) throws  Exception{
        String[] para = dataId.split(",");
        try{
            // 循环删除， 思考：删除前需不需要 通过id 去查找改id对应的用户是否存在
            for (int i = 0; i < para.length; i++) {
                subwayService.deleteSubwayById(para[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "redirect:/subway/list";
        }
    }
}
