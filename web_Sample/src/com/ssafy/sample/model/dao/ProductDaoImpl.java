package com.ssafy.sample.model.dao;

import com.ssafy.sample.dto.productDto;

public class ProductDaoImpl implements ProductDao {
	
	// 싱글턴
	private static ProductDaoImpl instance = new ProductDaoImpl();
	private ProductDaoImpl() {};
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int BoardAdd(productDto productdto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
