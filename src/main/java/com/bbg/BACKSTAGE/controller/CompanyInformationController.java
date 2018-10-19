package com.bbg.BACKSTAGE.controller;

import com.bbg.BACKSTAGE.common.PageHelper;
import com.bbg.BACKSTAGE.model.CivilAffairsBureauInformation;
import com.bbg.BACKSTAGE.model.CompanyInformation;
import com.bbg.BACKSTAGE.service.CivilAffairsBureauInformationService;
import com.bbg.BACKSTAGE.service.CompanyInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/20
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class CompanyInformationController {

    @Autowired
    private CompanyInformationService companyInformationService;

    @ResponseBody
    @GetMapping(value = "/go2companyinformation", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2CompanyInformation(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("companyinformation.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/addcompany", produces = {"application/json;charset=UTF-8"})
    public ModelAndView addCivilAffairsBureau(HttpServletRequest request, CompanyInformation companyInformation, BindingResult result,
                                              RedirectAttributes redirect) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("realname") != null && companyInformation.getLinkdate() != null) {
            companyInformation.setChargeman(request.getSession().getAttribute("realname").toString());
        }
        int flag = companyInformationService.addCompany(companyInformation);
        if (flag == 1) {
            mv.addObject("message", "添加成功！");
        } else {
            mv.addObject("message", "添加失败！");
        }
        mv.setViewName("companyinformation.html");

        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/getallcompany", produces = {"application/json;charset=UTF-8"})
    public PageHelper<CompanyInformation> getAllCompanyInformation(CompanyInformation companyInformation, HttpServletRequest request) {

        PageHelper<CompanyInformation> pageHelper = new PageHelper<>();
        // 统计总记录数
        Integer total = companyInformationService.getTotal();
        pageHelper.setTotal(total);


        if (companyInformation.getSort() != null && companyInformation.getSortOrder() != null) {
            if (companyInformation.getSearchContent() != null && companyInformation.getSearchContent() != "" && companyInformation.getSearchTarget() != null && companyInformation.getSearchTarget() != "") {
                List<CompanyInformation> list = companyInformationService.searchBySingleColumnSort(companyInformation);
                pageHelper.setRows(list);
            } else {
                List<CompanyInformation> list = companyInformationService.getCompanyPageSort(companyInformation);
                pageHelper.setRows(list);
            }
        } else {
            if (companyInformation.getSearchContent() != null && companyInformation.getSearchContent() != "" && companyInformation.getSearchTarget() != null && companyInformation.getSearchTarget() != "") {
                List<CompanyInformation> list = companyInformationService.searchBySingleColumn(companyInformation);
                pageHelper.setRows(list);
            } else {
                // 查询当前页实体对象
                List<CompanyInformation> list = companyInformationService.getCompanyListPage(companyInformation);
                pageHelper.setRows(list);
            }
        }


        return pageHelper;


    }

    @ResponseBody
    @PostMapping(value = "/editcompany", produces = {"application/json;charset=UTF-8"})
    public ModelAndView editCompanyInformation(HttpServletRequest request, CompanyInformation companyInformation, BindingResult result,
                                               RedirectAttributes redirect) {

        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("realname") != null && companyInformation.getLinkdate() != null) {
            companyInformation.setChargeman(request.getSession().getAttribute("realname").toString());
        }
        int flag = companyInformationService.updateCompany(companyInformation);
        if (flag == 1) {
            mv.addObject("message", "编辑成功！");
        } else {
            mv.addObject("message", "编辑失败！");
        }
        mv.setViewName("companyinformation.html");

        return mv;

    }

    @ResponseBody
    @PostMapping(value = "/deletecompany", produces = {"application/json;charset=UTF-8"})
    public ModelAndView deleteCompany(HttpServletRequest request, CompanyInformation companyInformation, BindingResult result,
                                      RedirectAttributes redirect) {

        ModelAndView mv = new ModelAndView();
        int flag = companyInformationService.deleteCompany(companyInformation);
        if (flag == 1) {
            mv.addObject("message", "删除成功！");
        } else {
            mv.addObject("message", "删除失败！");
        }

        mv.setViewName("companyinformation.html");

        return mv;

    }

}
