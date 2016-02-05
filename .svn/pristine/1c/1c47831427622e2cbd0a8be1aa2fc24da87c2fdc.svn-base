package com.zp.jdb.service;

import java.util.List;

import com.zp.jdb.entity.B_Brand;
import com.zp.jdb.entity.Brand;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.CustomerO;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.Order_inHours;
import com.zp.jdb.entity.S_Series;
import com.zp.jdb.entity.Series;

public interface CarInformationService {
	public void isinsertCarInfo(Car c);
    public void isupdateStatus(Long id);
    public Order_inHours findOrderByIdAndStatus(Long id);
    public CustomerO findUser_id(String idCard);
    public List<B_Brand> findBrand();
    public List<S_Series> findSeries(int bid);
    public List<B_Brand> findById(int id);
    public void insertCarImg(Img_forcar car);

    
    public void addname(String BName);
    public void addxilie(Series s);
}
