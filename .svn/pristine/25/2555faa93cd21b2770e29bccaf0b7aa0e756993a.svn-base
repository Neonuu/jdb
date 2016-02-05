package com.zp.jdb.dao;

import java.util.List;

import com.zp.jdb.entity.B_Brand;
import com.zp.jdb.entity.Brand;
import com.zp.jdb.entity.Car;
import com.zp.jdb.entity.Img_forcar;
import com.zp.jdb.entity.S_Series;
import com.zp.jdb.entity.Series;

public interface CarInformationDao {
     public void insertCarInfo(Car c);
     public void updateStatus(Long id);
     public List<B_Brand> findBrand();
     public List<S_Series> findSeries(int bid);  
     public List<Car> findByOrderNumber(String order_number);
     public List<B_Brand> findById(int id);
     public void insertCarImg(Img_forcar car);
     
     public void addname(String BName);
     public void addxilie(Series s);
}
