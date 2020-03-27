package com.chaiyc.springboot.controller.user;

import com.chaiyc.springboot.entities.user.User;
import com.chaiyc.springboot.service.user.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户管理控制器
 */
@Controller
@RequestMapping("/user")
public class UserController {


    @Autowired
    UserService userService;

    /**
     * 查询列表
     * @return
     */
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(name = "pageNum",defaultValue = "1") int pageNo,
                       @RequestParam(name = "page.size",defaultValue = "8") int pageSize) throws  Exception{

        PageInfo<User> pageInfo = userService.getPageUser(pageNo,pageSize);

        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("url","/user/list");

        return "user/user_list";
    }


    /**
     * 进入添加页面 (也是修改页面)
     */
    @GetMapping("/edit")
    public String edit(){
        return "user/user_edit";
    }

    /**
     * 添加用户
     */
    @PostMapping("/save")
    public String save(User user) throws  Exception {
        userService.saveUser(user);
        return "redirect:/user/list";
    }

    /**
     * 修改用户
     */
    @PutMapping("/update")
    public String update(User user) throws  Exception{
        userService.saveUpdate(user);
        return "redirect:/user/list";
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete")
    public String delete(Integer id) throws  Exception{
        userService.deleteUserById(id);
        return "redirect:/user/list";
    }




}
