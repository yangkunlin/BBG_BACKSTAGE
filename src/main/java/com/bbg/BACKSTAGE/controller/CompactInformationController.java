package com.bbg.BACKSTAGE.controller;

import com.bbg.BACKSTAGE.common.PageHelper;
import com.bbg.BACKSTAGE.model.CompactInformation;
import com.bbg.BACKSTAGE.service.CompactInformationService;
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
 * Date:    2018/9/22
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class CompactInformationController {

    @Autowired
    private CompactInformationService compactInformationService;

    @ResponseBody
    @GetMapping(value = "/go2compactinformation", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2CompactInformation(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("compactinformation.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/addcompact", produces = {"application/json;charset=UTF-8"})
    public ModelAndView addCompact(HttpServletRequest request, CompactInformation compactInformation, BindingResult result,
                                              RedirectAttributes redirect) {
        ModelAndView mv = new ModelAndView();
        int flag = compactInformationService.addCompany(compactInformation);
        if (flag == 1) {
            mv.addObject("message", "添加成功！");
        } else {
            mv.addObject("message", "添加失败！");
        }
        mv.setViewName("compactinformation.html");

        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/getallcompact", produces = {"application/json;charset=UTF-8"})
    public PageHelper<CompactInformation> getAllCompactInformation(CompactInformation compactInformation, HttpServletRequest request) {

        PageHelper<CompactInformation> pageHelper = new PageHelper<>();
        // 统计总记录数
        Integer total = compactInformationService.getTotal();
        pageHelper.setTotal(total);


        if (compactInformation.getSort() != null && compactInformation.getSortOrder() != null) {
            if (compactInformation.getSearchContent() != null && compactInformation.getSearchContent() != "" && compactInformation.getSearchTarget() != null && compactInformation.getSearchTarget() != "") {
                List<CompactInformation> list = compactInformationService.searchBySingleColumnSort(compactInformation);
                pageHelper.setRows(list);
            } else {
                List<CompactInformation> list = compactInformationService.getCompactPageSort(compactInformation);
                pageHelper.setRows(list);
            }
        } else {
            if (compactInformation.getSearchContent() != null && compactInformation.getSearchContent() != "" && compactInformation.getSearchTarget() != null && compactInformation.getSearchTarget() != "") {
                List<CompactInformation> list = compactInformationService.searchBySingleColumn(compactInformation);
                pageHelper.setRows(list);
            } else {
                // 查询当前页实体对象
                List<CompactInformation> list = compactInformationService.getCompactListPage(compactInformation);
                pageHelper.setRows(list);
            }
        }


        return pageHelper;


    }

    @ResponseBody
    @PostMapping(value = "/editcompact", produces = {"application/json;charset=UTF-8"})
    public ModelAndView editCompactInformation(HttpServletRequest request, CompactInformation compactInformation, BindingResult result,
                                               RedirectAttributes redirect) {

        ModelAndView mv = new ModelAndView();
        int flag = compactInformationService.updateCompact(compactInformation);
        if (flag == 1) {
            mv.addObject("message", "编辑成功！");
        } else {
            mv.addObject("message", "编辑失败！");
        }
        mv.setViewName("compactinformation.html");

        return mv;

    }

    @ResponseBody
    @PostMapping(value = "/deletecompact", produces = {"application/json;charset=UTF-8"})
    public ModelAndView deleteCompact(HttpServletRequest request, CompactInformation compactInformation, BindingResult result,
                                      RedirectAttributes redirect) {

        ModelAndView mv = new ModelAndView();
        int flag = compactInformationService.deleteCompact(compactInformation);
        if (flag == 1) {
            mv.addObject("message", "删除成功！");
        } else {
            mv.addObject("message", "删除失败！");
        }

        mv.setViewName("compactinformation.html");

        return mv;

    }

}
