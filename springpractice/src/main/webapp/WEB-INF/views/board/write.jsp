<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

	<h1>글쓰기</h1>
	<form action="write" method="post">
		제목<input type="text" name="title" required><br><br>
		내용<textarea name="content" required></textarea><br><br>
		
		<button>등록하기</button>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>