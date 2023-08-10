<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
	<h1>게시글 수정하기</h1>
	
	<form action="edit" method="post">
	
	제목<input type="text" name="changeBoardTitle" value="${boardDto.boardTitle}"><br><br>
	내용<br>
		<textarea rows="30" cols="50" name="changeBoardContent">${boardDto.boardContent}</textarea><br><br>
		<button>등록하기</button>
	
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>