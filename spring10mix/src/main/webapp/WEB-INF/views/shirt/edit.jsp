<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>셔츠 수정하기</title>
</head>
<body>
	<h1>셔츠 수정하기</h1>
	<form action="edit" method="post">
	
		<input type="hidden" name="shirtNo" value="${dto.shirtNo}">
		상품제목:<input type ="text" name="shirtName" 
		value="${dto.shirtName}" required><br><br>
		상품색상:<select name="shirtColor" value="${dto.shirtColor}"  required>
			<option value="${dto.shirtColor}">${dto.shirtColor}(현재값)</option>
			<option>블랙</option>
			<option>화이트</option>
			<option>그레이</option>
			<option>레드</option>
			<option>블루</option>
		</select><br><br>
		판매가:<input type="number" name="shirtPrice" 
		value="${dto.shirtPrice}" required><br><br>
		상품종류:<select name="shirtKind">
		<option>라운드</option>
		<option>브이넥</option>
		<option>정장</option>
		</select><br><br>
		상품유형:<select name="shirtType">
		<option>민소매</option>
		<option>반팔</option>
		<option>긴팔</option>
		</select><br><br>
		재질:<input type="text" name="shirtMaterial" 
		value="${dto.shirtMaterial}" required><br><br>
		재고:<input type="number" name="shirtStock" 
		value="${dto.shirtStock}" required><br><br>
	<button>수정하기</button>
	</form>
<a href="detail?shirtNo=${dto.shirtNo}">
	<button>돌아가기</button>
</a>
</body>
</html>