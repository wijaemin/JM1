<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
</head>
<body>
	<h1>게시글 수정</h1>
	<form action="edit" method="post">
		<input type="hidden" name="boardNo" value="${dto.boardNo}">
	제목<input type="text" name ="boardTitle" value="${dto.boardTitle}"><br><br>
	<!-- (참고)textarea에는 value가 없다 -->
	내용<textarea name="boardContent">${dto.boardContent}</textarea><br><br>
<%-- 	내용<input type =text" name="boardContent" value="${dto.boardContent}"><br><br> --%>
		<button>변경</button>
	</form>
</body>
</html>