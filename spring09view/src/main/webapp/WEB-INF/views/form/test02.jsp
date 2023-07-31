<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록 기능 만들기</title>
</head>
<body>
	<h1>게시글 등록 기능 만들기</h1>
	<form action="http://localhost:8080/insert">
		게시글 제목:<input name="boardTitle"><br><br>
		게시글 글쓴이:<input name="boardWriter"><br><br>
<!-- 		게시글 내용:<input name="boardContent"><br><br> -->
		게시글 내용:<textarea name="boardContent" rows="10" cols="100">	</textarea><br><br>
		
		<button>등록</button>
	</form>
</body>
</html>