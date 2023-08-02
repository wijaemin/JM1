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
			<h2>게시글 제목:${dto.boardTitle }</h2>
				게시글 내용:${dto.boardContent }
		<h5>게시글 작성자:${dto.boardWriter }</h5>
			<h5>게시글 조회수:${dto.boardReadcount }</h5>

		</c:when>
		
		<c:otherwise>
		
		<h1>Sorry</h1>
		
		</c:otherwise>
		
	</c:choose>
</body>
</html>