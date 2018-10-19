package com.bbg.BACKSTAGE.controller;

import com.bbg.BACKSTAGE.common.MyServlet;
import com.bbg.BACKSTAGE.common.Page;
import com.bbg.BACKSTAGE.common.PageHelper;
import com.bbg.BACKSTAGE.common.utils.MapUtil;
import com.bbg.BACKSTAGE.model.CompanyInformation;
import com.bbg.BACKSTAGE.model.UserInformation;
import com.bbg.BACKSTAGE.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:  yangkunlin
 * Date:    2018/9/16
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class UserInformationController extends MyServlet {

    @Autowired
    private UserInformationService userInformationService;

    @ResponseBody
    @GetMapping(value = "/go2userinformation", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2userinformation(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)) {
            mv.setViewName("userinformation.html");
        } else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @GetMapping(value = "/logout", produces = {"application/json;charset=UTF-8"})
    public ModelAndView logout(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession() == null) {
            mv.setViewName("login.html");
        } else {
            request.getSession().removeAttribute("userLogin");
            request.getSession().removeAttribute("username");
            request.getSession().removeAttribute("realname");
            request.getSession().removeAttribute("authority");
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/adduser", produces = {"application/json;charset=UTF-8"})
    public ModelAndView addUser(HttpServletRequest request, UserInformation userInformation, BindingResult result,
                                RedirectAttributes redirect) {
        ModelAndView mv = new ModelAndView();
        int flag = userInformationService.addUser(userInformation);
        if (flag == 1) {
            mv.addObject("message", "添加成功！");
        } else {
            mv.addObject("message", "添加失败！");
        }
        mv.setViewName("userinformation.html");

        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/getalluserinformation", produces = {"application/json;charset=UTF-8"})
    public PageHelper<UserInformation> getAllUserInformation(UserInformation userInformation, HttpServletRequest request) {

        PageHelper<UserInformation> pageHelper = new PageHelper<UserInformation>();
        // 统计总记录数
        Integer total = userInformationService.getTotal();
        pageHelper.setTotal(total);

        // 查询当前页实体对象
        List<UserInformation> list = userInformationService.getUserListPage(userInformation);
        pageHelper.setRows(list);

        return pageHelper;

    }

    @ResponseBody
    @PostMapping(value = "/getuserinformation", produces = {"application/json;charset=UTF-8"})
    public void getUserInformation(HttpServletRequest request, UserInformation userInformation, BindingResult result,
                                   RedirectAttributes redirect, HttpServletResponse response) {

        Map<String, Object> userInformationMap = new HashMap<>();
        if (request.getSession().getAttribute("username") != null) {
            String username = request.getSession().getAttribute("username").toString();
            UserInformation userInformationReset = userInformationService.selectUserByUsername(username);
            userInformationMap = MapUtil.beanToMap(userInformationReset);
            userInformationMap.put("userLogin", true);
            super.writeJson(userInformationMap, response);
        } else {
            userInformationMap.put("userLogin", false);
            super.writeJson(userInformationMap, response);
        }

    }

    @ResponseBody
    @PostMapping(value = "/edituser", produces = {"application/json;charset=UTF-8"})
    public ModelAndView editUser(HttpServletRequest request, UserInformation userInformation, BindingResult result,
                                 RedirectAttributes redirect) {

        ModelAndView mv = new ModelAndView();
        int flag = userInformationService.updateUser(userInformation);
        if (flag == 1) {
            mv.addObject("message", "编辑成功！");
        } else {
            mv.addObject("message", "编辑失败！");
        }
        mv.setViewName("userinformation.html");

        return mv;

    }

    @ResponseBody
    @PostMapping(value = "/changepassword", produces = {"application/json;charset=UTF-8"})
    public void changePassword(HttpServletRequest request, UserInformation userInformation, BindingResult result,
                               RedirectAttributes redirect, HttpServletResponse response) {

        Map<String, Object> responseMap = new HashMap<>();
        if (request.getSession().getAttribute("username") != null) {
            String username = request.getSession().getAttribute("username").toString();
            UserInformation userInformationReset = userInformationService.selectUserByUsername(username);
            userInformationReset.setPassword(userInformation.getPassword());
            userInformationService.updateUser(userInformationReset);
            responseMap.put("changepassword", true);
            super.writeJson(responseMap, response);
        } else {
            responseMap.put("changepassword", false);
            super.writeJson(responseMap, response);
        }

    }

}
