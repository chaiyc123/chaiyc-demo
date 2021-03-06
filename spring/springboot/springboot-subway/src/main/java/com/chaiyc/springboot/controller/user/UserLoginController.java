package com.chaiyc.springboot.controller.user;

import com.chaiyc.springboot.entities.user.User;
import com.chaiyc.springboot.service.user.UserService;
import com.chaiyc.springboot.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户登陆控制器
 */
@Controller
public class UserLoginController {


    @Autowired
    UserService userService;

    /**
     * 进入首页
     * @return
     */
    @GetMapping("/main")
    public String index(Model model){
        //加载首页显示的数据

        String currentDate = DateUtil.formatDate(new Date(), "yyyy-MM-dd");

        //查询
        List<String> list = userService.CountMainInfo(currentDate);

        model.addAttribute("list",list.get(0));
        return "main";
    }

    @PostMapping(value = "/user/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, String> maps, HttpSession session)throws Exception{

        User user = userService.login(username,password);

        if(user != null){
            if (user.getLoginAccount().equals(username) && user.getLoginPassword().equals(password)){
                session.setAttribute("loginUser",user);
                return "redirect:/main"; //登陆成功，防止表单重复提交，使用重定向到主页，主页路径在视图解析器中已经添加映射
            }else{
                maps.put("msg","用户或密码错误！");
                return "login";
            }
        }else{
            maps.put("msg","用户或密码错误！");
            return "login";
        }
    }

    @RequestMapping(value = "/login/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        Object userSession = request.getSession().getAttribute("loginUser");
        if (null != userSession) {
            request.getSession().removeAttribute("loginUser");
        }
        request.getSession().invalidate();
        return "login";
    }

}
