<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>전체 회원 리스트</h1>

<c:if test="${vo.search}">	
<%-- 검색일 경우 검색어를 추가로 출력 --%>
<h3>&quot;${vo.keyword}&quot;에 대한 검색 결과</h3>
</c:if>

	<table border="1" width="800">
	
	<thead>
		<tr>
			<th>아이디</th>
			<th>닉네임</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>생년월일</th>
			<th>등급</th>
			<th>메뉴</th>
		</tr>
	</thead>
	<tbody align="center">
	<c:forEach var="memberListDto" items="${list}">
		<tr>
			<td>${memberListDto.memberId}</td>
			<td>${memberListDto.memberNickname}</td>
			<td>${memberListDto.memberContact}</td>
			<td>${memberListDto.memberEmail}</td>
			<td>${memberListDto.memberBirth}</td>
			<td>${memberListDto.memberLevel}</td>
			<td>
				<a href="detail?memberId=${memberListDto.memberId }">상세</a>
				<a href="#">수정</a>
				<a href="#">차단</a>
			</td>
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
		<c:when test="${vo.type == 'member_nickname'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname" selected>닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type == 'member_contact'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact" selected>전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type == 'member_email'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email" selected>이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:when>
		<c:when test="${vo.type == 'member_birth'}">
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth" selected>생년월일</option>
			</select>
		</c:when>
		<c:otherwise>
			<select name="type">
				<option value="member_id">아이디</option>
				<option value="member_nickname">닉네임</option>
				<option value="member_contact">전화번호</option>
				<option value="member_email">이메일</option>
				<option value="member_birth">생년월일</option>
			</select>
		</c:otherwise>
	</c:choose>
		<input type="search" name="keyword" required
				placeholder="검색어 입력"  value="${vo.keyword}">
			<button>검색</button>
	</form>
	<a href="list"><button>전체 리스트</button></a>
	

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>