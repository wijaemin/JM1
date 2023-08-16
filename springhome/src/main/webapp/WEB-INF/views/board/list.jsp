<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시판</h1>
			<form action="list">
		<select name="type" >
			<option value="">선택하세요</option>
			<option value="board_title">제목</option>
			<option value="board_writer" >작성자</option>
		</select>
		<input type="text" name="keyword">
		<button>검색</button>
	</form>
	<c:choose>
	
	<c:when test="${sessionScope.name !=null}">
	<a href="write"><button>글쓰기</button></a>
	</c:when>
	<c:otherwise>
	<a href="/member/login"><button>글쓰기</button></a>
	</c:otherwise>
	</c:choose>
	<a href="list"><button>게시판으로</button></a>


	<table border="1" width="900">
	
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th width="20%">제목</th>
				<th>조회수</th>
				<th>좋아요</th>
				<th>댓글수</th>
				<th width="15%">작성일</th>
				<th width="15%">수정일</th>
			</tr>
		</thead>
		<tbody align="center">
		
		

		<c:forEach var="boardDto" items="${list}">
			<tr>
				<td>${boardDto.boardNo}</td>	
				<%--
					<c:choose>
					<c:when test="${boardDto.boardWriter !=null }">
						<td>${boardDto.boardWriter}</td>
					</c:when>
					<c:otherwise>
						<td>(탈퇴한 사용자)</td>
					</c:otherwise>
				</c:choose>	
				 --%>
				 <td>${boardDto.getBoardWriterString()}</td>
				<td align="left">
					<a href="detail?boardNo=${boardDto.boardNo}">
						${boardDto.boardTitle}
					</a>
					<!-- 댓글이 있다면 댓글 개수 표시 -->
					<c:if test="${boardDo.boardReplycount >0}">
					[${boardDto.boardReplycount}]
					</c:if>
				</td>			
				<td>${boardDto.boardReadcount}</td>				
				<td>${boardDto.boardLikecount}</td>			
				<td>${boardDto.boardReplycount}</td>			
				<td>${boardDto.boardCtimeString}</td>			
				<td>${boardDto.boardUtime}</td>			
			</tr>
		</c:forEach>
		
		
		</tbody>
		
		

	</table>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>