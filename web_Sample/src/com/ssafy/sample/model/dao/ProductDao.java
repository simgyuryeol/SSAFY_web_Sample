package com.ssafy.sample.model.dao;

import java.util.List;

import com.ssafy.sample.dto.productDto;

public interface ProductDao {
	int ProductAdd(productDto productdto); //상품 정보 등록
	int ProductDelete(productDto productdto);//상품 정보 삭제
	List<productDto> ProductList(int limit, int offset); //상품 목록
}
