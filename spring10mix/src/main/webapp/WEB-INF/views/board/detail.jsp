<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dto.boardNo}번 게시글 정보</title>
</head>
<body>
	<c:choose>
		<c:when test="${dto!=null}">
		
		<h1>${dto.boardNo}번게시글 정보</h1>
		<table border="1" width="500">
		
			<tr >
			<th width ="25%">게시글 제목</th>
			<td>${dto.boardTitle }</td>
			</tr>
			
			<tr>
			<th>게시글 작성자</th>
			<td>${dto.boardWriter }</td>
			</tr>
			
			<tr>
			<th>게시글 조회수</th>
			<td>${dto.boardReadcount }</td>
			</tr>
			
			<tr height="150" >
			<th>게시글 내용</th>
			<td style="word-wrap:break-word;">${dto.boardContent }</td>
			</tr>
			
 		</table>
		</c:when>
		
		<c:otherwise>
		
		<h1>Sorry</h1>
		
		</c:otherwise>
		
	</c:choose>
	
<a href="list">목록으로 이동</a>
</body>
</html>