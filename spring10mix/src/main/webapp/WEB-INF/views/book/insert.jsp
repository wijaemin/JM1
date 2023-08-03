<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<body>
	<h1>도서 등록</h1>
	<form action="insert"method="post">
	 제목<input type="text" name="bookTitle" 
	 required><br><br>
	 저자<input type="text" name="bookAuthor" 
	 required><br><br>
	 출간일<input type="date" name="bookPublicationDate" 
	 required><br><br>
	가격<input type="number" step="0.01"  name="bookPrice"
	 required><br><br>
	출판사<input type="text" name="bookPublisher"
	required><br><br>
	페이지 수<input type="number" name="bookPageCount"
	required><br><br>
	장르<input type="text" name="bookGenre"
	required><br><br>
	<button>등록</button>
	</form>
	
<a href="list">목록으로 돌아가기</a>
</body>
</html>