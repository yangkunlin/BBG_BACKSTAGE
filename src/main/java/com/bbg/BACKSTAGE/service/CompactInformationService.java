package com.bbg.BACKSTAGE.service;

import com.bbg.BACKSTAGE.model.CompactInformation;
import com.bbg.BACKSTAGE.model.CompanyInformation;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/22
 * Domain:  pla.hc10
 */
public interface CompactInformationService {

    Integer addCompany(CompactInformation compactInformation);

    //查询记录总数
    Integer getTotal();

    //分页查询所有记录
    List<CompactInformation> getCompactListPage(CompactInformation compactInformation);

    int updateCompact(CompactInformation compactInformation);

    List<CompactInformation> getCompactPageSort(CompactInformation compactInformation);

    int deleteCompact(CompactInformation compactInformation);

    List<CompactInformation> searchBySingleColumnSort(CompactInformation compactInformation);

    List<CompactInformation> searchBySingleColumn(CompactInformation compactInformation);

}
