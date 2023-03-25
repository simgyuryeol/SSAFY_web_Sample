package com.ssafy.sample.model.service;

import java.util.List;

import com.ssafy.sample.dto.productDto;

public interface ProductService {
	int ProductAdd(productDto productdto); //상품 정보 등록
	List<productDto> ProductList(int limit, int offset); //상품 목록
}
