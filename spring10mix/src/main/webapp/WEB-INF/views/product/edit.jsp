<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 수정하기</title>
</head>
<body>
	<h1>제품 수정하기</h1>
	<form action="edit" method="post">
		<input type="hidden" name="no" value="${dto.no}">
		이름:<input type="text" name="name" value="${dto.name}" required><br><br>
		종류:<select name="type">
			<option value="${dto.type}">${dto.type}(현재값)</option>
			<option>과자</option>
			<option>아이스크림</option>
			<option>주류</option>
			<option>사탕</option>
		</select><br><br>
		가격:<input type="number" name="price" value="${dto.price}"><br><br>
		제조일:<input type="date" name="made" value="${dto.made}"><br><br>
		만기일:<input type="date" name="expire" value="${dto.expire}"><br><br>
		<button>수정하기</button>
	</form>
	<br><a href="detail?no=${dto.no}"><button>돌아가기</button></a>
</body>
</html>