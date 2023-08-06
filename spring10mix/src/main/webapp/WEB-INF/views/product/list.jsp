<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 전체 조회</title>
</head>
<body>
	<h1>제품 전체 조회</h1>
	<a href="add"><button>등록하기</button></a>
	<table border="1" width="700">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>종류</th>
				<th>가격</th>
				<th>제조일</th>
				<th>만기일</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="dto" items="${list}">
			<tr>
				<td>${dto.no}</td>
				<td>
				<a href="detail?no=${dto.no}">${dto.name}</a>
				</td>
				<td>${dto.type}</td>
				<td>${dto.price}원</td>
				<td>${dto.made}</td>
				<td>${dto.expire}</td>
				<td><a href="delete?no=${dto.no}">삭제</a></td>
			</tr>
		</c:forEach>	
		</tbody>
	</table>
</body>
</html>