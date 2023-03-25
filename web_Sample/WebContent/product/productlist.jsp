<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String contextpath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/head.jsp" %>
<meta charset="UTF-8">
<script
    src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
    integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
    crossorigin="anonymous"></script>
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
    integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
    crossorigin="anonymous"></script>
    
<title>상품 목록</title>
</head>
<body>
	<%@ include file="../include/nav.jsp" %>
	<div class="container mt-3"><!-- mt-3 추가 -->
		<h4 class="text-center">상품 목록</h4>
		
		<table class="table table-hover">
		    <thead>
		         <tr>
		            <th>code</th>
		            <th>model</th>
		            <th>price</th>
		      </tr>
		   </thead>
		   <tbody id="boardTbody">
		   </tbody>
		</table>
		
		<div id="paginationWrapper"></div>
	 
	</div>

<script>
	var LIST_ROW_COUNT = 10;    //limit
	var OFFSET = 0;   // limit 10 offet 10
	var SEARCH_WORD = "";
	
	var PAGE_LINK_COUNT = 10;    // pagination link 갯수
	var TOTAL_LIST_ITEM_COUNT = 0;
	var CURRENT_PAGE_INDEX = 1;
	
	window.onload = function(){
		boardList();
		
	}
	
	async function boardList(){
		let url = "<%= contextPath%>/productList";
		let urlParmas = "?limit="+LIST_ROW_COUNT+"&offset="+OFFSET+"&searchWord="+SEARCH_WORD;
		
		try{
			let response = await fetch(url+urlParams);
			let data = await response.json();
			console.log(data);
			makeListHtml(data);
		}catch(error){
			console.error(error);
		}
	}
	
	function makeListHtml(list){
		let listHtml = ``;
		
		list.forEach( el => {
			let code = el.code;
			let model = el.model;
			let price = el.price;
			
			listHtml += `<tr style="cusor:pointer"><td>\${code}</td><td>\${model}</td><td>\${price}</td>  </tr>`;
		});
		
		document.querySelector("#boardTbody").innerHTML = listHTML;
		
	}

</script>

<%@ include file="../include/footer.jsp" %>