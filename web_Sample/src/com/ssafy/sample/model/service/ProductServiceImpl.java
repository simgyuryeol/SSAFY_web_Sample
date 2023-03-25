package com.ssafy.sample.model.service;

public class ProductServiceImpl implements ProductService{
	//싱글턴
	private static  ProductServiceImpl instance = new ProductServiceImpl();
	private ProductServiceImpl() {};
	
	public static ProductServiceImpl getInstance() {
		return instance;
	}
	
	
}
