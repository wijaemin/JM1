<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="edit" method="post" enctype="multipart/form-data">
	<input type="hidden" name="no" value="${pocketmonDto.no}">
	
	이름:<input type="text" name="name" value="${pocketmonDto.name}"><br><br>
	속성:<input type="text" name="type" value="${pocketmonDto.type}"><br><br>
	
	<!-- input[type=file]은 절대로 value 설정 불가 (보안 위험)  -->
	<input type="file" name="attach"><br><br>
	<c:if test="${pocketmonDto.image}">
		<img src="image?no=${pocketmonDto.no}" width="100" height="100">
	</c:if>
	<button type="submit">수정하기</button>
</form>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>