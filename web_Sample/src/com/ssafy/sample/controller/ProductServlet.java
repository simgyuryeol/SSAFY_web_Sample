package com.ssafy.sample.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.sample.dto.productDto;
import com.ssafy.sample.model.service.ProductService;
import com.ssafy.sample.model.service.ProductServiceImpl;

@WebServlet("/product/*")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    ProductService ps = ProductServiceImpl.getInstance();
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String contextPath = request.getContextPath();
		String path = request.getRequestURI().substring(contextPath.length());
		switch(path) {
		case "/product/regist.jsp": regist(request,response); break;
		case "/product/productlist.jsp": ProductList(request,response); break;
		}
		
	}
	protected void ProductList(HttpServletRequest request, HttpServletResponse response) {
		String strLimit = request.getParameter("limit");
		String strOffset = request.getParameter("offset");
		
		int limit = Integer.parseInt(strLimit);
		int offset = Integer.parseInt(strOffset);
		List<productDto> productlist = ProductService.ProductList(limit,offset);
	}
	protected void regist(HttpServletRequest request, HttpServletResponse response) {
		
	}
	
	
}
