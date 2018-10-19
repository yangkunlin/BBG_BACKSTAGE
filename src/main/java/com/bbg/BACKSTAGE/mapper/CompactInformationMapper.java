package com.bbg.BACKSTAGE.mapper;

import com.bbg.BACKSTAGE.model.CompactInformation;

import java.util.List;

public interface CompactInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompactInformation record);

    int insertSelective(CompactInformation record);

    CompactInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CompactInformation record);

    int updateByPrimaryKey(CompactInformation record);

    Integer getTotal();

    List<CompactInformation> getCompactListPage(CompactInformation compactInformation);

    List<CompactInformation> getCompactPageSort(CompactInformation compactInformation);

    List<CompactInformation> searchBySingleColumnSort(CompactInformation compactInformation);

    List<CompactInformation> searchBySingleColumn(CompactInformation compactInformation);
}