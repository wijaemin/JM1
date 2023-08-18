<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<c:choose>
	<c:when test="${isReply}">
		<h2>답글 작성</h2>
	</c:when>
	<c:otherwise>
		<h2>게시글 작성</h2>
	</c:otherwise>
</c:choose>
	<form action="write" method="post" autocomplete="off"> 
		<%-- 답글일 때만 추가 정보를 전송 --%>
		<c:if test="${isReply}">
			<input type="hidden" name="boardParent" value="${originDto.boardNo}">
		</c:if>
		<c:choose>
			<c:when test="${isReply}">
				제목<input type="text" name="boardTitle" 
				value="RE:${originDto.boardTitle}" required><br><br>
			</c:when>
		</c:choose>
<!-- 		제목<input type="text" name="boardTitle" required><br><br> -->
		내용<br>
		<textarea rows="30" cols="50" name="boardContent" required></textarea><br><br>
		<button>등록하기</button>
		
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>