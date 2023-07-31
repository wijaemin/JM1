<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 다루기</title>
</head>
<body>
	<h1>이미지 다루기</h1>
	<!-- 
		화면에 이미지 띄우기
		-원하는 곳에 원하는 크기로 이미지를 띄우기 위한 태그
		-종료 태그가 없음(일회성 태그)
		-크기를 폭(width)과 높이(height)를 부여할 수 있다
		-크기의 단위는 픽셀(px)이다
		-비율도 지정 가능하다.
	 -->
	 <img width="10" src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMDA5MjhfMjIg%2FMDAxNjAxMzAyNTU3NTYw.sqwJ59m1p_cpezaWU12n3rZ0OPizvlkZEwcf_ONFtnYg.dJCjG5C3I7_pPB4G8z7Ot2iV7ebs_gBqQSZ2VwTvrEAg.JPEG.nagne7272%2F%25BF%25B9%25BB%25DB_%25C0%25AF%25B8%25AE_%25B9%25AB%25B4%25CC_%25B9%25E8%25B0%25E6%25C8%25AD%25B8%25E9_%25289%2529.jpg&type=ofullfill340_600_png">
	 
	 <br><br>
	 <!-- 
		내가 가진 이미지를 추가할 경우 /static에 저장한 뒤 호출
		-http://localhost:9999/이름으로 호출 가능
	  -->
	  <img width ="300" height = "300" src="/screen.gif">
	  <br><br>	
	  <img width ="40%" src="/chunsik.gif">
	  <img width ="600" height = "600" src="/z.PNG">
	  
</body>
</html>