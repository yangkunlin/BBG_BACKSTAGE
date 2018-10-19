package com.bbg.BACKSTAGE.service;

import com.bbg.BACKSTAGE.model.CivilAffairsBureauInformation;
import com.bbg.BACKSTAGE.model.UserInformation;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/17
 * Domain:  pla.hc10
 */
public interface CivilAffairsBureauInformationService {

    Integer addCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation);

    //查询记录总数
    Integer getTotal();

    //分页查询所有记录
    List<CivilAffairsBureauInformation> getCivilAffairsBureauListPage(CivilAffairsBureauInformation civilAffairsBureauInformation);

    int updateCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation);

    List<CivilAffairsBureauInformation> getCivilAffairsBureauListPageSort(CivilAffairsBureauInformation civilAffairsBureauInformation);

    int deleteCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation);

    List<CivilAffairsBureauInformation> searchBySingleColumnSort(CivilAffairsBureauInformation civilAffairsBureauInformation);

    List<CivilAffairsBureauInformation> searchBySingleColumn(CivilAffairsBureauInformation civilAffairsBureauInformation);
}
