<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


	<c:if test="${sessionScope.name ==boardDto.boardWriter}">
	<a href="delete?boardNo=${boardDto.boardNo}"><button>삭제하기</button></a>
	<a href="edit?boardNo=${boardDto.boardNo}"><button>수정하기</button></a>
	</c:if>
	<c:choose>
	
	<c:when test="${boardDto!=null}">
	
	<h2>게시판 상세 조회</h2>
	<a href= "list"><button>게시판으로</button></a>
	<table border="1" width="500">
		<tr>
			<th>글번호</th>
			<td>${boardDto.boardNo}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${memberDto.memberNickname}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.boardTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${boardDto.boardContent}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${boardDto.boardReadcount}</td>
		</tr>
		<tr>
			<th>좋아요</th>
			<td>${boardDto.boardLikecount}</td>
		</tr>
		<tr>
			<th>댓글수</th>
			<td>${boardDto.boardReplycount}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${boardDto.boardCtime}</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>${boardDto.boardUtime}</td>
		</tr>
	
	</table>
	</c:when>
	<c:otherwise>
	<h1>이런 게시글은 없어용</h1>
	</c:otherwise>
	
	</c:choose>
		<c:if test="${param.error !=null}">
		<h3>아이디 또는 비밀번호가 일치하지 않습니다</h3>
	</c:if>	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>