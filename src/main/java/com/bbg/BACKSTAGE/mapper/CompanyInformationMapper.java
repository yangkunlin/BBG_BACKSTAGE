package com.bbg.BACKSTAGE.mapper;

import com.bbg.BACKSTAGE.model.CompanyInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CompanyInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompanyInformation record);

    int insertSelective(CompanyInformation record);

    CompanyInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompanyInformation record);

    int updateByPrimaryKey(CompanyInformation record);

    Integer getCompanyTotal();

    List<CompanyInformation> getCompanyListPage(CompanyInformation companyInformation);

    List<CompanyInformation> getCompanyPageSort(CompanyInformation companyInformation);

    List<CompanyInformation> searchBySingleColumnSort(CompanyInformation companyInformation);

    List<CompanyInformation> searchBySingleColumn(CompanyInformation companyInformation);
}