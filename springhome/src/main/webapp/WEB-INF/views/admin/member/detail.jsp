<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


	<a href="list"><button>전체 리스트로 돌아가기</button></a>
	<h2>${memberDto.memberId}회원의 상세 정보</h2>
	
	<table border="1" width="500">
		
<!-- 		<tr> -->
<!-- 			<th>회원아이디</th> -->
<%-- 			<td>${memberDto.memberId}</td> --%>
<!-- 		</tr> -->
		<tr>
			<th>닉네임</th>
			<td>${memberDto.memberNickname}</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${memberDto.memberEmail}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${memberDto.memberContact}</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${memberDto.memberBirth}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
			[${memberDto.memberPost}]
			${memberDto.memberAddr1}
			${memberDto.memberAddr2}		
			</td>
		</tr>
		<tr>
		<th>등급</th>
		<td>${memberDto.memberLevel}</td>
		</tr>
		<tr>
		<th>포인트</th>
			<td>
				<fmt:formatNumber value="${memberDto.memberPoint}" 
										pattern="#,##0"></fmt:formatNumber>pt
			</td>
		</tr>
		<tr>
		<th>가입일</th>
				<td>
					<fmt:formatDate value="${memberDto.memberJoin}" 
									pattern="y년 M월 d일 E a h시 m분 s초"/>
				</td>
		</tr>
		<tr>
		<th>마지막로그인</th>
				<td>
					<fmt:formatDate value="${memberDto.memberLogin}" 
									pattern="y년 M월 d일 E a h시 m분 s초"/>
				</td>
		</tr>
		<tr>
		<th>마지막변경일</th>
				<td>
					<fmt:formatDate value="${memberDto.memberChange}" 
									pattern="y년 M월 d일 E a h시 m분 s초"/>
				</td>
		</tr>		
	</table>
	<table border="1" width="500">
		<thead>
		<tr>
			<th width="75%">제목</th>
			<th>작성일</th>
		</tr>
		</thead>
		<tbody>
			<c:forEach var="boardListDto" items="${boardList}">
			<tr>
				<td>
					<a href="/board/detail?boardNo=${boardListDto.boardNo}">
						${boardListDto.boardTitle}
					</a>
				</td>
				<td>${boardListDto.boardCtime}</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>








<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>