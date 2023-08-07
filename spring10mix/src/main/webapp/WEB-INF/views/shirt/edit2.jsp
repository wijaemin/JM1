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
	<form action="edit2" method="post">
	
		<input type="hidden" name="shirtNo" value="${shirtDto.shirtNo}">
		상품제목:<input type ="text" name="shirtName" 
		value="${shirtDto.shirtName}" required><br><br>
		상품색상:<select name="shirtColor" value="${shirtDto.shirtColor}"  required>
		<%--El의 특징
		-외따옴표, 쌍따옴표 모두 문자열로 취습
		-문자열도 비교연산이 가능
		 --%>
			<option value="${shirtDto.shirtColor}">${shirtDto.shirtColor}(현재값)</option>
			<option>블랙</option>
			<option>화이트</option>
			<option>그레이</option>
			<option>레드</option>
			<option>블루</option>
		</select><br><br>
		판매가:<input type="number" name="shirtPrice" 
		value="${shirtDto.shirtPrice}" required><br><br>
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
		value="${shirtDto.shirtMaterial}" required><br><br>
		재고:<input type="number" name="shirtStock" 
		value="${shirtDto.shirtStock}" required><br><br>
		
		<!--  체크 박스를 만들 때 체크 처리해야됨 -->
		<hr>
		
		<input type="checkbox" name="size" value ="S">S
		<input type="checkbox" name="size" value ="M">M
		<input type="checkbox" name="size" value ="L">L
		<input type="checkbox" name="size" value ="XL">XL
		<input type="checkbox" name="size" value ="2XL">2XL
		<input type="checkbox" name="size" value ="3XL">3XL
		
		<hr>
		
		
	<button>수정하기</button>
	</form>
<a href="detail2?shirtNo=${shirtDto.shirtNo}">
	<button>돌아가기</button>
</a>
</body>
</html>