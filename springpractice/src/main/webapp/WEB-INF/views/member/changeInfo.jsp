<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	
	<form action="changeInfo" method="post">
		닉네임:<input type="text" name ="nickname" 
		value="${memberDto.nickname}" required><br><br>
		전화번호:<input type="tel" name ="contact" 
		value="${memberDto.contact}"><br><br>
		주소<br>
		<input type="text" name ="post" size="6" maxlength="6"
		placeholder="우편번호" value="${memberDto.post}"><br>
		<input type="text" name ="addr1" 
		placeholder="기본주소" value="${memberDto.addr1}" size="30"><br>
		<input type="text" name ="addr2" 
		placeholder="상세주소" value="${memberDto.addr2}" size="30"><br><br>
		
		비밀번호 확인<input type="password" name="password" required><br><br>
		<button>변경하기</button>
	</form>
		
		<c:if test="${param.error !=null}">
			<h2>비밀번호가 일치하지 않습니다</h2>
		</c:if>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>