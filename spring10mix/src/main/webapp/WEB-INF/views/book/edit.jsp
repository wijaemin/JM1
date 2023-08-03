<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 수정</title>
</head>
<body>
	<h1>도서 수정</h1>
		<form action="edit" method="post">
		
		<input type="hidden" name="bookId" value="${dto.bookId}" required>
		<input type="text" name="bookTitle" value="${dto.bookTitle}"><br><br>
		<input type="text" name="bookAuthor" value="${dto.bookAuthor}"><br><br>
		<input type="date" name="bookPublicationDate" value="${dto.bookPublicationDate}"><br><br>
		<input type="number" step="0.01" name="bookPrice" value="${dto.bookPrice}"><br><br>
		<input type="text" name="bookPublisher" value="${dto.bookPublisher}"><br><br>
		<input type="number" name="bookPageCount" value="${dto.bookPageCount}"><br><br>
		<input type="text" name="bookGenre" value="${dto.bookGenre}"><br><br>
		<button>수정하기</button>
	
		
		</form>
</body>
</html>