<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>
	<style>
    input[name=addr1]{
        border-bottom: none;
    }
    </style>
    
	<form action="changeInfo" method="post">
		<div class="container w-400">
			<div class="row left">
				<label>닉네임</label>
				<input type="text" name ="nickname" class="form-input w-100" 
				value="${memberDto.nickname}" placeholder="한글 또는 숫자 2~10자 이내" required>
			</div>
			<div class="row left">
				<label>전화번호</label>
				<input type="tel" name ="contact" class="form-input w-100" 
				value="${memberDto.contact}" placeholder="- 제외하고 입력">
			</div>
			<div class="row left">
				<label style="display: block;">주소</label>
				<input type="text" name ="post" size="6" maxlength="6" class="form-input" 
				placeholder="우편번호" value="${memberDto.post}">
				</div>
			<div class="row">
				<input type="text" name ="addr1" class="form-input w-100"  
				placeholder="기본주소" value="${memberDto.addr1}" size="30">
				<input type="text" name ="addr2" class="form-input w-100"  
				placeholder="상세주소" value="${memberDto.addr2}" size="30">
			</div>
			
			<div class="row left">
				<label>비밀번호 확인</label>
				<input type="password" name="password" class="form-input w-100" required><br><br>
			</div>
			<div class="row">
				<button class="btn btn-positive w-100">변경하기</button>
			</div>
		</div>
	</form>
		
		<c:if test="${param.error !=null}">
			<h2>비밀번호가 일치하지 않습니다</h2>
		</c:if>
	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>