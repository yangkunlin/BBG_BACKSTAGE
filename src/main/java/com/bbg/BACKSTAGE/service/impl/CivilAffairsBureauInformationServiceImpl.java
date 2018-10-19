package com.bbg.BACKSTAGE.service.impl;

import com.bbg.BACKSTAGE.mapper.CivilAffairsBureauInformationMapper;
import com.bbg.BACKSTAGE.model.CivilAffairsBureauInformation;
import com.bbg.BACKSTAGE.service.CivilAffairsBureauInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/17
 * Domain:  pla.hc10
 */
@Service(value = "civilAffairsBureauInformationService")
public class CivilAffairsBureauInformationServiceImpl implements CivilAffairsBureauInformationService {

    @Autowired
    private CivilAffairsBureauInformationMapper civilAffairsBureauInformationMapper;//这里会报错，但是并不会影响

    @Override
    public Integer addCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.insert(civilAffairsBureauInformation);
    }

    @Override
    public Integer getTotal() {
        return civilAffairsBureauInformationMapper.getTotal();
    }

    @Override
    public List<CivilAffairsBureauInformation> getCivilAffairsBureauListPage(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.getCivilAffairsBureauListPage(civilAffairsBureauInformation);
    }

    @Override
    public int updateCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.updateByPrimaryKey(civilAffairsBureauInformation);
    }

    @Override
    public List<CivilAffairsBureauInformation> getCivilAffairsBureauListPageSort(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.getCivilAffairsBureauListPageSort(civilAffairsBureauInformation);
    }

    @Override
    public int deleteCivilAffairsBureau(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.deleteByPrimaryKey(civilAffairsBureauInformation.getId());
    }

    @Override
    public List<CivilAffairsBureauInformation> searchBySingleColumnSort(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.searchBySingleColumnSort(civilAffairsBureauInformation);
    }

    @Override
    public List<CivilAffairsBureauInformation> searchBySingleColumn(CivilAffairsBureauInformation civilAffairsBureauInformation) {
        return civilAffairsBureauInformationMapper.searchBySingleColumn(civilAffairsBureauInformation);
    }

}
