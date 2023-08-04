<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셔츠 상세 조회</title>
</head>
<body>
	<c:choose>
	<c:when test="${dto!=null}" >
	<h1>셔츠 상세 조회</h1>
	
	<h2>${dto.shirtNo}번 셔츠</h2>
	
	<a href="edit?shirtNo=${dto.shirtNo}"><button>수정하기</button></a>
	<a href="delete?shirtNo=${dto.shirtNo}"><button>삭제하기</button></a>
	<br>
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
			<th>판매가</th>
			<td>
			<fmt:formatNumber value="${dto.shirtPrice}" pattern="#,###"/>원
			</td>
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
			<td>
			<fmt:formatNumber value="${dto.shirtStock}" pattern="#,###"/>개
			</td>
		</tr>
	</table>
	</c:when>
	<c:otherwise>
	sorry..
	</c:otherwise>
</c:choose>
<a href="list">
<button>목록으로</button>
</a>
</body>
</html>