<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>






<h1>${boardDto.no}번 게시글</h1>
	<table border="1" width="600">
		<tr>
			<th>작성자</th>
			<td>
			${memberDto.nickname}
			(${boardDto.writerString})
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="right">
			조회수 ${boardDto.readcount} 좋아요 ${boardDto.likecount} 댓글 ${boardDto.replycount}
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.title}</td>
		</tr>				
		<tr height="150">
			<th>내용</th>
			<td>${boardDto.content}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
				<fmt:formatDate value="${boardDto.createdAt}" pattern="Y년 M월 d일 E a h시 m분 s초"/>
			</td>
		</tr>
		<tr>
			<th>수정일</th>
			<td>
			<fmt:formatDate value="${boardDto.updatedAt}" pattern="Y년 M월 d일 E a h시 m분 s초"/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<c:if test="${sessionScope.email !=null}">
				<a href="write">글쓰기</a>
				<a href="write?boardParent=${boardDto.no}">답글쓰기</a>
				<c:if test="${sessionScope.email == boardDto.writer}">
					<a href="edit?no=${boardDto.no}">수정하기</a>
					<a href="delete?no=${boardDto.no}">삭제하기</a>
				</c:if>
				</c:if>			
				<a href="list">목록보기</a>
			</td>
		</tr>
		

	</table>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>