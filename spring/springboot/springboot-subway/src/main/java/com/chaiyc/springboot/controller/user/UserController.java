package com.chaiyc.springboot.controller.user;

import com.chaiyc.springboot.entities.user.User;
import com.chaiyc.springboot.service.user.UserService;
import com.chaiyc.springboot.utils.DateUtil;
import com.chaiyc.springboot.utils.StringUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    public String edit(Model model, String dataId,HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 通过id 判断是添加 还是修改页面
        if (StringUtil.isNotEmpty(dataId)){
            User user = userService.getUserById(dataId);
            model.addAttribute("user",user);
        }
        return "user/user_edit";
    }

    /**
     * 添加用户
     */
    @PostMapping("/save")
    public String save(User user, HttpServletRequest request, HttpServletResponse response)
            throws  Exception {

        if(StringUtil.isNotEmpty(user.getUserAcctId())){
            userService.updateUser(user);
        }else{
            // 设置创建时间
            user.setCreateTime(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
            // 设置默认的登陆密码为 "123456",后面优化 进行加密
            user.setLoginPassword("123456");
            // 设置默认状态 为启用
            user.setUserState("1");
            userService.saveUser(user);
        }

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
    @RequestMapping("/delete")
    public String delete(String dataId) throws  Exception{
        String[] para = dataId.split(",");
        try{
            // 循环删除， 思考：删除前需不需要 通过id 去查找改id对应的用户是否存在
            for (int i = 0; i < para.length; i++) {
                userService.deleteUserById(para[i]);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            return "redirect:/user/list";
        }
    }




}
