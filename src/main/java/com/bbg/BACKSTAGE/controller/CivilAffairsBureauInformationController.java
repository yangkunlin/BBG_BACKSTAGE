package com.bbg.BACKSTAGE.controller;

import com.bbg.BACKSTAGE.common.PageHelper;
import com.bbg.BACKSTAGE.model.CivilAffairsBureauInformation;
import com.bbg.BACKSTAGE.service.CivilAffairsBureauInformationService;
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
 * Date:    2018/9/17
 * Domain:  pla.hc10
 */
@Controller
@RequestMapping(value = "/")
public class CivilAffairsBureauInformationController {

    @Autowired
    private CivilAffairsBureauInformationService civilAffairsBureauInformationService;

    @ResponseBody
    @GetMapping(value = "/go2civilaffairsbureau", produces = {"application/json;charset=UTF-8"})
    public ModelAndView go2userinformation(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        if (request.getSession().getAttribute("userLogin") != null && request.getSession().getAttribute("userLogin").equals(true)){
            mv.setViewName("civilaffairsbureau.html");
        }else {
            mv.setViewName("login.html");
        }
        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/addcivilaffairsbureau", produces = {"application/json;charset=UTF-8"})
    public ModelAndView addCivilAffairsBureau(HttpServletRequest request, CivilAffairsBureauInformation civilAffairsBureauInformation, BindingResult result,
                                              RedirectAttributes redirect) {
        ModelAndView mv = new ModelAndView();
        int flag = civilAffairsBureauInformationService.addCivilAffairsBureau(civilAffairsBureauInformation);
        if (flag == 1) {
            mv.addObject("message", "添加成功！");
        } else {
            mv.addObject("message", "添加失败！");
        }
        mv.setViewName("civilaffairsbureau.html");

        return mv;
    }

    @ResponseBody
    @PostMapping(value = "/getallcivilaffairsbureau", produces = {"application/json;charset=UTF-8"})
    public PageHelper<CivilAffairsBureauInformation> getAllUserInformation(CivilAffairsBureauInformation civilAffairsBureauInformation, HttpServletRequest request)  {

        PageHelper<CivilAffairsBureauInformation> pageHelper = new PageHelper<CivilAffairsBureauInformation>();
        // 统计总记录数
        Integer total = civilAffairsBureauInformationService.getTotal();
        pageHelper.setTotal(total);

        if (civilAffairsBureauInformation.getSort() != null && civilAffairsBureauInformation.getSortOrder() != null) {
            if (civilAffairsBureauInformation.getSearchContent() != null && civilAffairsBureauInformation.getSearchContent() != "" && civilAffairsBureauInformation.getSearchTarget() != null && civilAffairsBureauInformation.getSearchTarget() != "") {
                List<CivilAffairsBureauInformation> list = civilAffairsBureauInformationService.searchBySingleColumnSort(civilAffairsBureauInformation);
                pageHelper.setRows(list);
            } else {
                List<CivilAffairsBureauInformation> list = civilAffairsBureauInformationService.getCivilAffairsBureauListPageSort(civilAffairsBureauInformation);
                pageHelper.setRows(list);
            }
        } else {
            if (civilAffairsBureauInformation.getSearchContent() != null && civilAffairsBureauInformation.getSearchContent() != "" && civilAffairsBureauInformation.getSearchTarget() != null && civilAffairsBureauInformation.getSearchTarget() != "") {
                List<CivilAffairsBureauInformation> list = civilAffairsBureauInformationService.searchBySingleColumn(civilAffairsBureauInformation);
                pageHelper.setRows(list);
            } else {
                // 查询当前页实体对象
                List<CivilAffairsBureauInformation> list = civilAffairsBureauInformationService.getCivilAffairsBureauListPage(civilAffairsBureauInformation);
                pageHelper.setRows(list);
            }
        }


        return pageHelper;


    }

    @ResponseBody
    @PostMapping(value = "/editcivilaffairsbureau", produces = {"application/json;charset=UTF-8"})
    public ModelAndView editCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation, HttpServletRequest request)  {

        ModelAndView mv = new ModelAndView();
        int flag = civilAffairsBureauInformationService.updateCivilAffairsBureau(civilAffairsBureauInformation);
        if (flag == 1) {
            mv.addObject("message", "编辑成功！");
        } else {
            mv.addObject("message", "编辑失败！");
        }
        mv.setViewName("civilaffairsbureau.html");

        return mv;

    }

    @ResponseBody
    @PostMapping(value = "/deletecivilaffiarsbureau", produces = {"application/json;charset=UTF-8"})
    public ModelAndView deleteCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation, HttpServletRequest request)  {

        ModelAndView mv = new ModelAndView();
        int flag = civilAffairsBureauInformationService.deleteCivilAffairsBureau(civilAffairsBureauInformation);
        if (flag == 1) {
            mv.addObject("message", "删除成功！");
        } else {
            mv.addObject("message", "删除失败！");
        }

        mv.setViewName("civilaffairsbureau.html");

        return mv;

    }

}
