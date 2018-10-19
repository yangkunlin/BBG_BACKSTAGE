package com.bbg.BACKSTAGE.service.impl;

import com.bbg.BACKSTAGE.mapper.CompanyInformationMapper;
import com.bbg.BACKSTAGE.model.CompanyInformation;
import com.bbg.BACKSTAGE.service.CompanyInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/20
 * Domain:  pla.hc10
 */
@Service(value = "companyInformationService")
public class CompanyInformationServiceI implements CompanyInformationService {

    @Autowired
    private CompanyInformationMapper companyInformationMapper;

    @Override
    public Integer addCompany(CompanyInformation companyInformation) {
        return companyInformationMapper.insert(companyInformation);
    }

    @Override
    public Integer getTotal() {
        return companyInformationMapper.getCompanyTotal();
    }

    @Override
    public List<CompanyInformation> getCompanyListPage(CompanyInformation companyInformation) {
        return companyInformationMapper.getCompanyListPage(companyInformation);
    }

    @Override
    public int updateCompany(CompanyInformation companyInformation) {
        return companyInformationMapper.updateByPrimaryKey(companyInformation);
    }

    @Override
    public List<CompanyInformation> getCompanyPageSort(CompanyInformation companyInformation) {
        return companyInformationMapper.getCompanyPageSort(companyInformation);
    }

    @Override
    public int deleteCompany(CompanyInformation companyInformation) {
        return companyInformationMapper.deleteByPrimaryKey(companyInformation.getId());
    }

    @Override
    public List<CompanyInformation> searchBySingleColumnSort(CompanyInformation companyInformation) {
        return companyInformationMapper.searchBySingleColumnSort(companyInformation);
    }

    @Override
    public List<CompanyInformation> searchBySingleColumn(CompanyInformation companyInformation) {
        return companyInformationMapper.searchBySingleColumn(companyInformation);
    }
}
