<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 추가</title>
</head>
<body>
	<h1>제품 추가</h1>
	<a href="list"><button>돌아가기</button></a><br><br>
	<form action="add" method="post">
		이름:<input type="text" name="name" required><br><br>
		종류:<select name="type">
		<option>과자</option>
		<option>아이스크림</option>
		<option>주류</option>
		<option>사탕</option>
		</select><br><br>
		가격:<input type="number" name="price"><br><br>
		<button>등록하기</button>
	</form>
</body>
</html>