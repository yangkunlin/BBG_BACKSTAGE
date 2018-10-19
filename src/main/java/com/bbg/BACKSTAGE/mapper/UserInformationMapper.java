package com.bbg.BACKSTAGE.mapper;

import com.bbg.BACKSTAGE.model.UserInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserInformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserInformation record);

    int insertSelective(UserInformation record);

    UserInformation selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInformation record);

    int updateByPrimaryKey(UserInformation record);

    //查询所有信息记录
    List<UserInformation> selectAll();

    //根据用户名查询
    UserInformation selectByUsername(String username);

    //查询记录总数
    Integer getTotal();

    //分页查询所有记录
    List<UserInformation> getUserListPage(UserInformation userInformation);
}