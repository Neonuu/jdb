package com.zp.jdb.dao;

import java.util.List;

import com.zp.jdb.entity.Perform_order;

public interface PerformDao {
	public List<Perform_order> Statistics(Perform_order ao);
	public int SelectTotalCount(Perform_order ao);
	

}
