package com.ssafy.sample.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<productDto> list = new ArrayList<>();
		
		
		try {
			con = DBUtil.getInstance().getConnection();
			//select 조회
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT code, model, price ")
			.append(" FROM product ")
			.append(" ORDER BY code ")
			.append(" LIMIT ? OFFSET ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				productDto productdto = new productDto();
				productdto.setCode(rs.getString("code"));
				productdto.setModel(rs.getString("model"));
				productdto.setPrice(rs.getInt("price"));
				list.add(productdto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.getInstance().close(con,pstmt,rs);
		}
		
		return list;
		
	}
	
	
	

}
