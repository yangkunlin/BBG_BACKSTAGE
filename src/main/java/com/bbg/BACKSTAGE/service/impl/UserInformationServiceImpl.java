package com.bbg.BACKSTAGE.service.impl;

import com.bbg.BACKSTAGE.common.Page;
import com.bbg.BACKSTAGE.mapper.UserInformationMapper;
import com.bbg.BACKSTAGE.model.UserInformation;
import com.bbg.BACKSTAGE.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/16
 * Domain:  pla.hc10
 */
@Service(value = "userInformationService")
public class UserInformationServiceImpl implements UserInformationService {

    @Autowired
    private UserInformationMapper userInformationMapper;//这里会报错，但是并不会影响

    @Override
    public int addUser(UserInformation user) {
        return userInformationMapper.insert(user);
    }

    /*
    * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
    * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
    * pageNum 开始页数
    * pageSize 每页显示的数据条数
    * */
    @Override
    public List<UserInformation> findAllUser() {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        return userInformationMapper.selectAll();
    }

    @Override
    public UserInformation selectUserByUsername(String username) {
        return userInformationMapper.selectByUsername(username);
    }

    @Override
    public Integer getTotal() {
        return userInformationMapper.getTotal();
    }

    @Override
    public List<UserInformation> getUserListPage(UserInformation userInformation) {
        return userInformationMapper.getUserListPage(userInformation);
    }

    @Override
    public int updateUser(UserInformation userInformation) {
        return userInformationMapper.updateByPrimaryKey(userInformation);
    }
}
