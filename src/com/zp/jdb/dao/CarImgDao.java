package com.zp.jdb.dao;

import java.util.List;
import com.zp.jdb.entity.Img_forcar;

public interface CarImgDao {
	
     public List<Img_forcar> findCarImgByOrderNumber(String order_number);
}
