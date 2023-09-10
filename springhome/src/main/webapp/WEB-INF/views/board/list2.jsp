<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

 <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
 
 <script src="/js/checkbox.js"></script>

<div class="container w-900">
		<div class="row">
			<h2>자유 게시판</h2>
		</div>
	
	<!-- 폼 시작 -->
	<form class="delete-form" action="deleteByAdmin" method="post">
	<%-- 
		검색일 경우 검색어를 추가로 출력 
		(참고) 논리 반환값을 가지는 getter 메소드는 get이 아니라 is로 시작한다
	--%>
	<c:if test="${vo.search}">
		<div class="row center">
			<h2>&quot;${vo.keyword}&quot;에 대한 검색 결과</h2>
		</div>
	</c:if>
	
	
	
	<%-- 글쓰기는 로그인 상태인 경우에만 출력 --%>
	<c:if test="${sessionScope.name != null}">
		<div class="row right">
		<c:if test="${sessionScope.level == '관리자'}">
			<button type="submit" class="btn btn-negative delete-btn">
				<i class="fa-solid fa-trash"></i>
					일괄 삭제
			</button>
		</c:if>
			<a href="write" class="btn"><i class="fa-solid fa-pen"></i>
			글쓰기
			</a>
		</div>
	</c:if>
	
		<div class="row">
			<table class="table table-stripe  table-border" >
				<thead>
					<tr>
					<c:if test="${sessionScope.level == '관리자'}">					
						<th>
					<!-- 전체 선택 체크 박스 -->
							<input type="checkbox" class="check-all">
						</th>
					</c:if>
						<th>번호</th>
						<th width="40%">제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
						<th>좋아요</th>
						<th>그룹</th>
						<th>상위</th>
						<th>차수</th>
					</tr>
				</thead>
				<tbody align="center">
					<c:forEach var="boardListDto" items="${list}">
					<tr>
						<c:if test="${sessionScope.level == '관리자'}">
						<!-- 개별 체크박스 -->
						<td><input type="checkbox" class="check-item" 
						name="boardNoList" value="${boardListDto.boardNo}"></td>
						</c:if>
						<td>${boardListDto.boardNo}</td>
						<td align="left">
							
							<%-- 차수만큼 띄어쓰기 출력
							
							 --%>
							<%-- for(int i=1; i <= 차수; i++) { --%>
							<c:forEach var="i" begin="1" end="${boardListDto.boardDepth}" step="1">
							&nbsp;&nbsp;
							</c:forEach>
							
							<%-- 띄어쓰기 뒤에 화살표 표시 --%>
							<c:if test="${boardListDto.boardDepth > 0}">
			<!-- 					<img src="https://dummyimage.com/15x15/000/fff"> -->
<!-- 								<img src="/images/reply.png" width="15" height="15"> -->
									<i class="fa-solid fa-reply fa-rotate-180"></i>
							</c:if>
							
						
							<!-- 제목을 누르면 상세페이지로 이동 -->
							<a href="detail?boardNo=${boardListDto.boardNo}">
								${boardListDto.boardTitle}
							</a>
							
							<!-- 댓글이 있다면 개수를 표시 -->
							<c:if test="${boardListDto.boardReplycount > 0}">
								<%--[${boardListDto.boardReplycount}] --%>
								&nbsp;&nbsp;
							<i class="fa-solid fa-comment blue"></i>
							${boardListDto.boardReplyCount}	
							</c:if>
						</td>
						
						<%-- 사용자가 없으면 탈퇴한 사용자로 표시 --%>
						<%--
						<c:choose>
							<c:when test="${boardListDto.boardWriter != null}">
								<td>${boardListDto.boardWriter}</td>
							</c:when>
							<c:otherwise>
								<td>(탈퇴한 사용자)</td>
							</c:otherwise>
						</c:choose>
						 --%>
						<td>${boardListDto.getBoardWriterString()}</td>
						
						<td>${boardListDto.boardCtimeString}</td>
						<td>${boardListDto.boardReadcount}</td>
						<td>${boardListDto.boardLikecount}</td>
						<td>${boardListDto.boardGroup}</td>
						<td>${boardListDto.boardParent}</td>
						<td>${boardListDto.boardDepth}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	<br>
	
	
	
	<!-- 폼 종료 -->
	
	</form>
	
	<!-- 페이지 네비게이터 출력 -->
	
	<div class="row page-navigator mv-30">
	<!-- 이전 버튼 -->
	<c:if test="${!vo.first}">
		<a href="list?${vo.prevQueryString}">
		<i class="fa-solid fa-angle-left"></i>
		</a>
	</c:if>
	
	<!-- 숫자 버튼 -->
	<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
		<c:choose>
			<c:when test="${vo.page == i}">
				<a class="on">${i}</a>	
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
	
	
	
	</div>
	<!-- 검색창 -->
	<form action="list" method="get">
	<div class="row">	
		<c:choose>
			<c:when test="${param.type == 'board_writer'}">
				<select name="type" required>
					<option value="board_title">제목</option>
					<option value="board_writer" selected>작성자</option>
				</select>
			</c:when>
			<c:otherwise>
				<select name="type" required>
					<option value="board_title">제목</option>
					<option value="board_writer">작성자</option>
				</select>
			</c:otherwise>
		</c:choose>
		
		
		<input type="search" name="keyword"  required class="form-input" 
					placeholder="검색어 입력" value="${param.keyword}">
		<button class="btn btn-positive">검색</button>
	</div>	
	</form>
	
	<br>
</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>


