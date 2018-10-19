package com.bbg.BACKSTAGE.mapper;

import com.bbg.BACKSTAGE.model.CivilAffairsBureauInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CivilAffairsBureauInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CivilAffairsBureauInformation record);

    int insertSelective(CivilAffairsBureauInformation record);

    CivilAffairsBureauInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CivilAffairsBureauInformation record);

    int updateByPrimaryKey(CivilAffairsBureauInformation record);

    //查询记录总数
    Integer getTotal();

    //分页查询所有记录
    List<CivilAffairsBureauInformation> getCivilAffairsBureauListPage(CivilAffairsBureauInformation civilAffairsBureauInformation);

    List<CivilAffairsBureauInformation> getCivilAffairsBureauListPageSort(CivilAffairsBureauInformation civilAffairsBureauInformation);

    List<CivilAffairsBureauInformation> searchBySingleColumnSort(CivilAffairsBureauInformation civilAffairsBureauInformation);

    List<CivilAffairsBureauInformation> searchBySingleColumn(CivilAffairsBureauInformation civilAffairsBureauInformation);
}