package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.ssafy.sample.dto.productDto;
import com.ssafy.sample.util.DBUtil;

public class ProductDaoImpl implements ProductDao {
	
	// 싱글턴
	private static ProductDaoImpl instance = new ProductDaoImpl();
	private ProductDaoImpl() {};
	
	public static ProductDaoImpl getInstance() {
		return instance;
	}


	@Override
	public int ProductAdd(productDto productdto) { //상품 정보 등록
		Connection con = null;
		PreparedStatement pstmt = null;
		
		int ret = -1;
		
		try {
			con = DBUtil.getInstance().getConnection();
			//insert
			StringBuilder sb = new StringBuilder();
			sb.append(" insert into product ")
			.append( "(code, model, price) ")
			.append(" values(?,?,? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, productdto.getCode());
			pstmt.setString(2, productdto.getModel());
			pstmt.setInt(3, productdto.getPrice());
			
			ret = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(pstmt, con);
		}
		
		return ret;
	}

	@Override
	public List<productDto> ProductList(int limit, int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
