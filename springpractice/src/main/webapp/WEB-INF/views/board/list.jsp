<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>



<h1>하이 게시판</h1>
<c:if test="${sessionScope.email !=null}">
	<a href="/board/write">
		<h2>글쓰러 가기</h2>
	</a>
</c:if>


<c:if test="${isSearch}">
	<h3>&quot;${param.keyword}&quot;에 대한 검색 결과</h3>
</c:if>
<table border="1" width="1000">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>좋아요수</th>
				<th>작성일</th>
				<th>수정일</th>
				<th>그룹</th>
				<th>상위</th>
				<th>차수</th>
			</tr>
		</thead>
		<tbody align="center">
			<c:forEach var="boardListDto" items="${list}">
			<tr>
				<td>
					${boardListDto.no}
				</td>
				<td align="left">
					
					<c:forEach var="i" begin="1" end="${boardListDto.boardDepth}" step="1">
						&nbsp;&nbsp;
					</c:forEach>
						<c:if test="${boardListDto.boardDepth>0}">
						<img  src="/images/depth.png" width="15" height="15">
						</c:if>
					
					<a href="detail?no=${boardListDto.no}">${boardListDto.title}</a>
					<c:if test="${boardListDto.replycount>0}">
						[${boardListDto.replycount}]
					</c:if>
					
				</td>
				<td>
					${boardListDto.writerString}
				</td>
				<td>
					${boardListDto.readcount}
				</td>
				<td>
					${boardListDto.likecount}
				</td>
				<td>
					${boardListDto.createdAtString}
				</td>
				<td>
					${boardListDto.updatedAt}
				</td>
				<td>
					${boardListDto.boardGroup}
				</td>
				<td>
					${boardListDto.boardParent}
				</td>
				<td>
					${boardListDto.boardDepth}
				</td>
			</tr>
			</c:forEach>
		</tbody>
	<tr>
	</tr>
</table>

<br>

<!-- 페이지 네비게이터 출력 -->

<h3>
<!-- 이전 버튼 -->
	
	<c:if test="${begin>1}">
		<c:choose>
			<c:when test="${isSearch}">
				<a href="list?page=${begin-1}&type=${param.type}&keyword=${param.keyword}">&lt;</a>	
			</c:when>
			<c:otherwise>
				<a href="list?page=${begin-1}">&lt;</a>
			</c:otherwise>
		</c:choose>		
	
		
	</c:if>
<!-- 숫자 버튼 -->
<c:forEach var="i" begin="${begin}" end="${end}" step="1">
	<c:choose>
		<c:when test="${page==i}">
			${i}
		</c:when>
		<c:otherwise>
		<!-- 링크는 검색과 목록을 따로 구현 -->
			<c:choose>
				<c:when test="${isSearch}">
					<a href="list?page=${i}&type=${param.type}&keyword=${param.keyword}">${i}</a>	
				</c:when>
				<c:otherwise>
					<a href="list?page=${i}">${i}</a>
				</c:otherwise>
			</c:choose>
		
			
		</c:otherwise>	
	</c:choose>
</c:forEach>

<!-- 다음 버튼 -->
	<c:if test="${end<pageCount}">
		<c:choose>
			<c:when test="${isSearch}">
				<a href="list?page=${end+1}&type=${param.type}&keyword=${param.keyword}">&gt;</a>	
			</c:when>
			<c:otherwise>
				<a href="list?page=${end+1}">&gt;</a>
			</c:otherwise>
		</c:choose>			
	
	

	</c:if>

</h3>
<!-- 검색창 -->
<form action="list" method="get">

	<c:choose>
		<c:when test="${param.type=='title'}">
			<select name="type">
				<option value="title" selected>제목</option>
				<option value="writer">작성자</option>
			</select>
		</c:when>
		<c:otherwise>
			<select name="type">
		<option value="title">제목</option>
		<option value="writer" selected>작성자</option>
			</select>
		</c:otherwise>
	</c:choose>
	
	<input type="search" name="keyword" placeholder="검색어 입력" value="${param.keyword}" required>
	<button>검색</button>
</form>

<br>


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>