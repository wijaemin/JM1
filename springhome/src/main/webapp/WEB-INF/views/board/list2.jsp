<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>게시판</h1>

<%--
	검색일 경우 검색어를 추가로 출력
	(참고) 논리 반환값을 가지는 getter 메소드는 get이 아니라 is로 시작한다
 --%>

<c:if test="${vo.search}">	
<%-- 검색일 경우 검색어를 추가로 출력 --%>
<h3>&quot;${vo.keyword}&quot;에 대한 검색 결과</h3>
</c:if>

<!-- 			<form action="list"> -->
<!-- 		<select name="type" > -->
<!-- 			<option value="">선택하세요</option> -->
<!-- 			<option value="board_title">제목</option> -->
<!-- 			<option value="board_writer" >작성자</option> -->
<!-- 		</select> -->
<!-- 		<input type="text" name="keyword"> -->
<!-- 		<button>검색</button> -->
<!-- 	</form> -->
	<c:choose>
	
	<c:when test="${sessionScope.name !=null}">
	<a href="write"><button>글쓰기</button></a>
	</c:when>
	<c:otherwise>
	<a href="/member/login"><button>글쓰기</button></a>
	</c:otherwise>
	</c:choose>
	<a href="list"><button>게시판으로</button></a>


	<table border="1" width="1000">
	
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
				<th>그룹</th>
				<th>상위</th>
				<th>차수</th>
			</tr>
		</thead>
		<tbody align="center">
		
		

		<c:forEach var="boardListDto" items="${list}">
			<tr>
				<td>${boardListDto.boardNo}</td>	
			
				 <td>${boardListDto.getBoardWriterString()}</td>
				<td align="left">
				
					<%-- for(int i=1;i<=차수;i++) --%>
					<c:forEach var="i" begin="1" end="${boardListDto.boardDepth}" step="1">
					&nbsp;&nbsp;
					
					</c:forEach>
					<%--띄어쓰기 뒤에 화살표 표시 --%>
					<c:if test="${boardListDto.boardDepth>0}">
<!-- 						→ -->
						<img src="/aaa.png"  width="15" height="15">
					</c:if>
					
					
					<a href="detail?boardNo=${boardListDto.boardNo}">
						${boardListDto.boardTitle}
					</a>
					<!-- 댓글이 있다면 댓글 개수 표시 -->
					<c:if test="${boardDo.boardReplycount >0}">
					[${boardListDto.boardReplycount}]
					</c:if>
				</td>			
				<td>${boardListDto.boardReadcount}</td>				
				<td>${boardListDto.boardLikecount}</td>			
				<td>${boardListDto.boardReplycount}</td>			
				<td>${boardListDto.boardCtimeString}</td>			
				<td>${boardListDto.boardUtime}</td>	
				<td>${boardListDto.boardGroup}</td>		
				<td>${boardListDto.boardParent}</td>		
				<td>${boardListDto.boardDepth}</td>		
			</tr>
		</c:forEach>
		
		
		</tbody>
			
		
	</table>
	
	
	<br>
	
	<!-- 페이지  네비게이터 출력-->
	<h3>
	<!-- 이전 버튼 -->
	<c:if test="${!vo.first}">
		<a href="list?${vo.prevQueryString}">&lt;</a>

	</c:if>
	<!-- 숫자 버튼 -->
	<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
		<c:choose>
			<c:when test="${vo.page==i }">
				${i}
			</c:when>
					<c:otherwise>
						<a href="list?${vo.getQueryString(i)}">${i}</a>
					</c:otherwise>
				</c:choose>
	</c:forEach>
	<!-- 다음 버튼 -->
	<c:if test="${!vo.last}">
				<a href="list?${vo.nextQueryString}">&gt;</a>
	</c:if>
	</h3>
	<br>
	
	
<!-- 검색창 -->
	<form action="list" >
		<c:choose>
			<c:when test="${param.type=='board_writer'}">
				<select name="type" >
					<option value="board_title">제목</option>
					<option value="board_writer" selected>작성자</option>
				</select>
			</c:when>
			<c:otherwise>
				<select name="type" >
					<option value="board_title">제목</option>
					<option value="board_writer" >작성자</option>
				</select>
			</c:otherwise>
		</c:choose>
		<input type="search" name="keyword" required
				placeholder="검색어 입력"  value="${param.keyword}">
			<button>검색</button>
	</form>
	
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>