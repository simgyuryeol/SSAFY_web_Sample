package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.productDto;
import com.ssafy.sample.model.dao.ProductDao;
import com.ssafy.sample.model.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	//싱글턴
	private static  ProductServiceImpl instance = new ProductServiceImpl();
	private ProductServiceImpl() {};
	
	public static ProductServiceImpl getInstance() {
		return instance;
	}
	
	ProductDao productdao = ProductDaoImpl.getInstance();

	@Override
	public int ProductAdd(productDto productdto) {
		return productdao.ProductAdd(productdto);
	}

	@Override
	public List<productDto> ProductList(int limit, int offset) {
		return productdao.ProductList(limit, offset);
	}

	@Override
	public int ProductDelete(productDto productdto) {
		return productdao.ProductDelete(productdto);
	}
	
	
}
