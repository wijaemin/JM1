<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib	prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<c:choose>
		<c:when test="${isReply}">
			<h2>답글 작성</h2>
		</c:when>
		<c:otherwise>
			<h2>게시글 달성</h2>
		</c:otherwise>
	</c:choose>
	<form action="write" method="post">
		<c:if test="${isReply}">
			<input type="hidden" name="boardParent" value="${originDto.no}">
		</c:if>
		
		<c:choose>
			<c:when test="${isReply}">
				제목<input type="text" name="title" 
					value="RE:${originDto.title}" required><br><br>
			</c:when>
			<c:otherwise>
				제목<input type="text" name="title" required><br><br>
			</c:otherwise>
		</c:choose>
		내용<textarea name="content" required></textarea><br><br>
		
		<button>등록하기</button>
	</form>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>