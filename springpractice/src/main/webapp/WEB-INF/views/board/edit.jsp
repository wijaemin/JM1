<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>수정하기</h1>
	<form action="edit" method="post">
		<input type="hidden" name="no" value="${boardDto.no}">	
		제목<input type="text" name="title" value="${boardDto.title}" required><br><br>
		내용<textarea name="content"required>${boardDto.content}</textarea><br><br>
		
		<button>등록하기</button>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>