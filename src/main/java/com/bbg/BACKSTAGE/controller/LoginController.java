package com.bbg.BACKSTAGE.controller;

import com.bbg.BACKSTAGE.model.UserInformation;
import com.bbg.BACKSTAGE.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author:  yangkunlin
 * Date:    2018/9/17
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    private UserInformationService userInformationService;


    @GetMapping // 4.3 版本后的新特性
    public ModelAndView toLoginForm(@ModelAttribute("errorMsg") String errorMsg, @ModelAttribute("user") UserInformation user) {
        // 返回 templates/login.html 页面, html 可以省略
        return new ModelAndView("/login");
    }

    @ResponseBody
    @GetMapping(value = "/go2index", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.html");
        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/login", produces = {"application/json;charset=UTF-8"})
    public ModelAndView login(HttpServletRequest request, UserInformation userInformation, BindingResult result,
                              RedirectAttributes redirect) {
//        // 如果 user 的字段不符合要求,则返回到登录页面,并将 valid error 信息传入登录页面
//        if (result.hasErrors()) {
//            return new ModelAndView("/userinformation", "formErrors", result.getAllErrors());
//        }
        ModelAndView mv = new ModelAndView();
//        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)) {
//            mv.setViewName("userinformation.html");
//            return mv;
//        }
        UserInformation userByUsername = userInformationService.selectUserByUsername(userInformation.getUsername());
        // 用户名或密码不正确
        if (userByUsername != null && !userByUsername.getUsername().isEmpty()) {

            if (userByUsername.getPassword().equals(userInformation.getPassword())) {
                // 将用户登录信息添加到 session 中
                request.getSession().setAttribute("userLogin", true);
                request.getSession().setAttribute("username", userByUsername.getUsername());
                request.getSession().setAttribute("realname", userByUsername.getRealname());
                request.getSession().setAttribute("authority", userByUsername.getAuthority());
                mv.setViewName("index.html");
                return mv;
            } else {
                // 添加错误消息,该消息将一起带到重定向后的页面,
                // 浏览器刷新后,该数据将消失
                redirect.addFlashAttribute("errorMsg", "登录失败,用户名或密码错误");
                // 重定向到 login.html 页面
                return new ModelAndView("redirect:/");
            }

        } else {
            // 添加错误消息,该消息将一起带到重定向后的页面,
            // 浏览器刷新后,该数据将消失
            redirect.addFlashAttribute("errorMsg", "登录失败,用户名或密码错误");
            // 重定向到 login.html 页面
            return new ModelAndView("redirect:/");
        }

    }
}
