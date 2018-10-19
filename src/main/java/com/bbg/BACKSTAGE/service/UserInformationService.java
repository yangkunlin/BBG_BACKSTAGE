package com.bbg.BACKSTAGE.service;

import com.bbg.BACKSTAGE.common.Page;
import com.bbg.BACKSTAGE.model.UserInformation;

import java.util.List;

/**
 * Author:  yangkunlin
 * Date:    2018/9/16
 * Domain:  pla.hc10
 */
public interface UserInformationService {
    int addUser(UserInformation user);

    List<UserInformation> findAllUser();

    UserInformation selectUserByUsername(String username);

    Integer getTotal();

    List<UserInformation> getUserListPage(UserInformation userInformation);

    int updateUser(UserInformation userInformation);
}
