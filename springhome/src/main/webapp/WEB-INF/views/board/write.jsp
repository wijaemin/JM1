<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>게시글 작성</h1>
	<form action="write" method="post" autocomplete="off"> 
		제목<input type="text" name="boardTitle" required><br><br>
		내용<br>
		<textarea rows="30" cols="50" name="boardContent" required></textarea><br><br>
		<button>등록하기</button>
		
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>