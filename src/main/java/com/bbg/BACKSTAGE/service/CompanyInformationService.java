package com.bbg.BACKSTAGE.service;

import com.bbg.BACKSTAGE.model.CompanyInformation;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/20
 * Domain:  pla.hc10
 */
public interface CompanyInformationService {

    Integer addCompany(CompanyInformation companyInformation);

    //查询记录总数
    Integer getTotal();

    //分页查询所有记录
    List<CompanyInformation> getCompanyListPage(CompanyInformation companyInformation);

    int updateCompany(CompanyInformation companyInformation);

    List<CompanyInformation> getCompanyPageSort(CompanyInformation companyInformation);

    int deleteCompany(CompanyInformation companyInformation);

    List<CompanyInformation> searchBySingleColumnSort(CompanyInformation companyInformation);

    List<CompanyInformation> searchBySingleColumn(CompanyInformation companyInformation);
}
