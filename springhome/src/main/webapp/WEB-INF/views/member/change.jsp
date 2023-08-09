<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<h1>개인정보 변경하기</h1>

<form action ="change" method="post">
	닉네임<input type= "text" name="memberNickname" 
				value ="${memberDto.memberNickname}" required><br><br>
	이메일<input type="email" name="memberEmail" 
				value="${memberDto.memberEmail}" ><br><br>
	연락처<input type="tel" name="memberContact" 
				value="${memberDto.memberContact}" ><br><br>
	생년월일<input type="date" name="memberBirth" 
				value="${memberDto.memberBirth}" ><br><br>
	주소<br>
				<input type="text" name="memberPost" size="6" maxlength="6"  
				placeholder="우편번호" value="${memberDto.memberPost}" ><br><br>
				<input type="text" name="memberAddr1" 
				placeholder="기본주소" value="${memberDto.memberAddr1}" ><br><br>
				<input type="text" name="memberAddr2" 
				placeholder="상세주소" value="${memberDto.memberAddr2}" ><br><br>

	현재 비밀번호를 입력하세요<br>
				<input type="password" name="memberPw"><br><br>
	<button>개인정보 변경</button>
</form>
	<c:if test="${param.error !=null}">
	<h2>비밀번호가 틀렸습니다</h2>
	</c:if>
	


<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>