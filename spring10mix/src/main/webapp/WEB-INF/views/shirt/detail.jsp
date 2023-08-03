<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셔츠 상세 조회</title>
</head>
<body>
	<h1>셔츠 상세 조회</h1>
	<table border="1" width="300">
		<tr>
			<th width="25%">상품제목</th>
			<td>${dto.shirtName}</td>	
		</tr>
		
		
		<tr>
			<th>상품색상</th>
			<td>${dto.shirtColor}</td>
		</tr>
		
		
		<tr>
			<th>상품가격</th>
			<td>${dto.shirtPrice}</td>
		</tr>
		
		
		<tr>
			<th>판매가</th>
			<td>${dto.shirtPrice}</td>
		</tr>
		
		
		<tr>
			<th>상품종류</th>
			<td>${dto.shirtKind}</td>
		</tr>
		
		
		<tr>
			<th>상품유형</th>
			<td>${dto.shirtType}</td>
		</tr>
		
		
		<tr>
			<th>재질</th>	
			<td>${dto.shirtMaterial}</td>
		</tr>
		
		
		<tr>
			<th>재고</th>	
			<td>${dto.shirtStock}</td>
		</tr>
	</table>

<h4><a href="list">목록으로</a></h4>
</body>
</html>