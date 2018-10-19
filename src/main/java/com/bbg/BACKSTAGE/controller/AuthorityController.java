package com.bbg.BACKSTAGE.controller;

import com.bbg.BACKSTAGE.common.MyServlet;
import com.bbg.BACKSTAGE.model.CompactInformation;
import com.bbg.BACKSTAGE.model.CompanyInformation;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Author:  yangkunlin
 * Date:    2018/9/21
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class AuthorityController extends MyServlet {

    @ResponseBody
    @PostMapping(value = "/adduserauthority", produces = {"application/json;charset=UTF-8"})
    public void addUserAuthority(HttpServletRequest request, CompanyInformation companyInformation, BindingResult result,
                                 RedirectAttributes redirect, HttpServletResponse response) {
        Map<String, Boolean> addUserAuthority = new HashMap<>();
        if (request.getSession().getAttribute("authority") != null) {
            String authority = request.getSession().getAttribute("authority").toString();
            if (authority.equals("1")) {
                addUserAuthority.put("addUserAuthority", true);
                super.writeJson(addUserAuthority, response);
            } else {
                addUserAuthority.put("addUserAuthority", false);
                super.writeJson(addUserAuthority, response);
            }
        } else {
            addUserAuthority.put("addUserAuthority", false);
            super.writeJson(addUserAuthority, response);
        }
    }

    @ResponseBody
    @PostMapping(value = "/addcompactauthority", produces = {"application/json;charset=UTF-8"})
    public void addCompactAuthority(HttpServletRequest request, CompactInformation compactInformation, BindingResult result,
                                    RedirectAttributes redirect, HttpServletResponse response) {
        Map<String, Boolean> addUserAuthority = new HashMap<>();
        if (request.getSession().getAttribute("authority") != null) {
            String authority = request.getSession().getAttribute("authority").toString();
            if (authority.equals("1") || authority.equals("2")) {
                addUserAuthority.put("addCompactAuthority", true);
                super.writeJson(addUserAuthority, response);
            } else {
                addUserAuthority.put("addCompactAuthority", false);
                super.writeJson(addUserAuthority, response);
            }
        } else {
            addUserAuthority.put("addCompactAuthority", false);
            super.writeJson(addUserAuthority, response);
        }
    }

}
