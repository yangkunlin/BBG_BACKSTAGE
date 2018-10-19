package com.bbg.BACKSTAGE.service.impl;

import com.bbg.BACKSTAGE.mapper.CompactInformationMapper;
import com.bbg.BACKSTAGE.model.CompactInformation;
import com.bbg.BACKSTAGE.service.CompactInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/22
 * Domain:  pla.hc10
 */
@Service(value = "compactInformationService")
public class CompactInformationServiceImpl implements CompactInformationService {

    @Autowired
    private CompactInformationMapper compactInformationMapper;

    @Override
    public Integer addCompany(CompactInformation compactInformation) {
        return compactInformationMapper.insert(compactInformation);
    }

    @Override
    public Integer getTotal() {
        return compactInformationMapper.getTotal();
    }

    @Override
    public List<CompactInformation> getCompactListPage(CompactInformation compactInformation) {
        return compactInformationMapper.getCompactListPage(compactInformation);
    }

    @Override
    public int updateCompact(CompactInformation compactInformation) {
        return compactInformationMapper.updateByPrimaryKey(compactInformation);
    }

    @Override
    public List<CompactInformation> getCompactPageSort(CompactInformation compactInformation) {
        return compactInformationMapper.getCompactPageSort(compactInformation);
    }

    @Override
    public int deleteCompact(CompactInformation compactInformation) {
        return compactInformationMapper.deleteByPrimaryKey(compactInformation.getId());
    }

    @Override
    public List<CompactInformation> searchBySingleColumnSort(CompactInformation compactInformation) {
        return compactInformationMapper.searchBySingleColumnSort(compactInformation);
    }

    @Override
    public List<CompactInformation> searchBySingleColumn(CompactInformation compactInformation) {
        return compactInformationMapper.searchBySingleColumn(compactInformation);
    }
}
