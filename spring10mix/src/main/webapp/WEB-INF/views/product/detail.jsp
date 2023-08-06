<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세 조회</title>
</head>
<body>
	<c:choose>
	<c:when test="${dto!=null}">
	<h1>${dto.no}번 제품 상세 조회</h1>
	<a href="list"><button>돌아가기</button></a>
	<a href="edit?no=${dto.no}"><button>수정하기</button></a>
	<a href="delete?no=${dto.no}"><button>삭제하기</button></a>
	<table border="1" width="250">
		<tr>
			<th>이름</th>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<th>종류</th>
			<td>${dto.type}</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${dto.price}원</td>
		</tr>
		<tr>
			<th>제조일</th>
			<td>${dto.made}</td>
		</tr>
		<tr>
			<th>만기일</th>
			<td>${dto.expire}</td>
		</tr>
		
	</table>
	</c:when>
	<c:otherwise>
	<h1>sorry요</h1>
	</c:otherwise>
	</c:choose>
</body>
</html>