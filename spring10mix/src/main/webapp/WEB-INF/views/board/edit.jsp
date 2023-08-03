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
		<input type="text" name ="boardTitle" value="${dto.boardTitle}"><br><br>
		<input type="hidden" name="boardWriter" value="${dto.boardWriter}">
		<input type =text" name="boardContent" value="${dto.boardContent}"><br><br>
		<button>변경</button>
	</form>
</body>
</html>