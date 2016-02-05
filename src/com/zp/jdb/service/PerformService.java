package com.zp.jdb.service;

import java.util.List;

import com.zp.jdb.entity.Perform_order;
import com.zp.jdb.entity.User;

public interface PerformService {
    public List<Perform_order> isStatistics(Perform_order ao);
    public int isSelectTotalCount(Perform_order ao);
    public List<User> selectUserInfo();
}
