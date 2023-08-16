<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


	<c:choose>
	
	<c:when test="${boardDto!=null}">
	
	<h2>${boardDto.boardNo}번 게시글</h2>
	<table border="1" width="500">
	
		<tr>
			<th>작성자(닉네임)</th>
			<td>${boardDto.boardWriter},(${memberDto.memberNickname})</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${boardDto.boardTitle}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td height="150">${boardDto.boardContent}</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
			조회수${boardDto.boardReadcount}
			좋아요${boardDto.boardLikecount}
			댓글${boardDto.boardReplycount}
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>
		<fmt:formatDate value="${boardDto.boardCtime}" pattern="y년M월d일 E a h시 m분 s초" />	
			</td>
		</tr>
		<tr>
			<th>수정일</th>
		<td>
		<fmt:formatDate value="${boardDto.boardUtime}" pattern="y년M월d일 E a h시 m분 s초" />
		</td>
		</tr>
		<tr>
		<td colspan="2" align="right">
			<%-- 회원일 때만 글쓰기,수정,삭제가 나와야한다 --%>
			<c:if test="${sessionScope.name !=null}">
			<a href="write"><button>글쓰기</button></a>
			<%-- 수정/삭제는 소유자일 경우만 나와야 한다 --%>
				<c:if test="${sessionScope.name == boardDto.boardWriter}">
					<a href="delete?boardNo=${boardDto.boardNo}"><button>삭제하기</button></a>
					<a href="edit?boardNo=${boardDto.boardNo}"><button>수정하기</button></a>
				</c:if>
			</c:if>
			<a href= "list"><button>게시판으로</button></a>
		</td>
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