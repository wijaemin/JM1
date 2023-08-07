<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셔츠 전체 조회</title>
</head>
<body>
	<h1>셔츠 전체 조회</h1>
<a href="add"><button>등록하기</button></a>
	<table border="1" width="900">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>색상</th>
				<th>가격</th>
				<th>종류</th>
				<th>유형</th>
				<th>재질</th>
				<th>재고</th>
				<th>삭제</th>			
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
				<td>
				<fmt:formatNumber value="${dto.shirtPrice}" pattern="#,###"/>원
				</td>
				<td>${dto.shirtKind}</td>
				<td>${dto.shirtType}</td>
				<td>${dto.shirtMaterial}</td>
				<td>
				<fmt:formatNumber value="${dto.shirtStock}" pattern="#,###"/>개
				</td>
				<td>
				<a href="delete?shirtNo=${dto.shirtNo}">
				<button>삭제하기</button>
				</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>