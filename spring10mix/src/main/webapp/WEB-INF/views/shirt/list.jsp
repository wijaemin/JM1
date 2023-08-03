<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셔츠 전체 조회</title>
</head>
<body>
	<h1>셔츠 전체 조회</h1>
	<h3><a href="add">등록하기</a></h3>
	<table border="1" width="700">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>색상</th>
				<th>가격</th>
				<th>종류</th>
				<th>유형</th>
				<th>재질</th>
				<th>재고</th>
			</tr>
		</thead>
		
		<tbody align="center">
			<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.shirtNo}</td>
				<td align="left">
					<a href="detail?shirtNo=${dto.shirtNo}">
					${dto.shirtName}
					</a>
				</td>
				<td>${dto.shirtColor}</td>
				<td>${dto.shirtPrice}</td>
				<td>${dto.shirtKind}</td>
				<td>${dto.shirtType}</td>
				<td>${dto.shirtMaterial}</td>
				<td>${dto.shirtStock}</td>
				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>