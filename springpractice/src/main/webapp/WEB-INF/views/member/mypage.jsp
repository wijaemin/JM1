<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<script>
$(function(){
	//파일이 변경되면 프로필 업로드 이미지 교체
	$(".profile-chooser").change(function(){
		//선택된 파일이 있는지 확인 없으면 중단
		console.log("하이");
		
		var input=this;
		if(input.files.length==0)return;
		//ajax로 multipart 업로드
		
		var form = new FormData();
		form.append("attach",input.files[0]);
		$.ajax({
			url:"/rest/member/upload",
			method:"post",
			processData:false,
			contentType:false,
			data:form,
			success:function(response){
				//응답형태 {"attachNo" : 7}
				//프로필 이미지 교체
				$(".profile-image").attr("src", 
						"/rest/member/download?attachNo="+response.attachNo);
			},
			error:function(){
				window.alert("통신 오류 발생");
			},
		});
	});
	
	//삭제 아이콘 누르면 프로필 제거
	$(".profile-delete").click(function(){
		
		var choice =window.confirm("정말 프로필을 지울겁니까?");
		if(choice == false)return;
		
		$.ajax({
			url:"/rest/member/delete",
			method:"post",
			success:function(response){
				$(".profile-image").attr("src","/images/profile.png");
			},
		});
	});
});
</script>

<div class="container w-500">
	<div class="row">
		<h2>${memberDto.nickname}님의 정보</h2>
	</div>
	
	<div class="row mv-30">
		<c:choose>
		<c:when test="${profile == null}">
			<img src="/images/profile.png"width="150" height="150" 
			class="image image-circle image-border profile-image">
		</c:when>
		<c:otherwise>
			<img src="/rest/member/download?attachNo=${profile}" 
			width="150" height="150" 
			class="image image-circle image-border profile-image">
		</c:otherwise>
		</c:choose>
		
		<!-- 라벨을 만들고 파일선택창을 숨김 -->
		<label>
			<input type="file" class="profile-chooser" accept="image/*" 
							style="display:none;">
			<i class="fa-solid fa-camera green fa-2x"></i>
		</label>
			<i class="fa-solid fa-trash red fa-2x profile-delete"></i>
	</div>
	
	
	<table class="table table-border">
	
		<tr>
			<th>이메일</th>
			<td>${memberDto.email}</td>
		</tr>
		<tr>
			<th>전화번호</th>
<%-- 			<td>${memberDto.contact}</td> --%>
			<td>
				<c:set var="phone" value="${memberDto.contact}"/>
				<c:if test="${memberDto.contact!=null}">
					<c:set var="formattedPhone" value="${fn:substring(phone, 0, 3)}-${fn:substring(phone, 3, 7)}-${fn:substring(phone, 7, 11)}"/>
					${formattedPhone}
				</c:if>
			</td>
		</tr>
		<tr>
			<th>생년월일</th>
			<td>${memberDto.birth}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				[${memberDto.post}]
				${memberDto.addr1}
				${memberDto.addr2}
			</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${memberDto.rank}</td>
		</tr>
		<tr>
			<th>포인트</th>
			<td>
				<fmt:formatNumber value="${memberDto.point}" pattern="#,##0">
				</fmt:formatNumber>pt
			</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>
				<fmt:formatDate value="${memberDto.joinAt}" 
				pattern="y년 M월 d일 E a h시 m분 s초"/>
			</td>
		</tr>
		<tr>
			<th>최근 접속일</th>
			<td>
				<fmt:formatDate value="${memberDto.loginAt}" 
				pattern="y년 M월 d일 E a h시 m분 s초"/>
			</td>
		</tr>
	
	
	</table>
	<div class="row">
		<a class="btn" href="changePw">비밀번호 변경</a>
		<a class="btn" href="changeInfo">개인정보 변경</a>
		<a class="btn" href="exit">계정 탈퇴</a>
	</div>
	
	<div class="row">
		<table class="table table-border table-stripe">
			<c:forEach var="boardDto" items="${boardLikeList}">
			<tr>
				<td class="w-75">
					<a href="/board/detail?no=${boardDto.no}">
					${boardDto.title}
					</a>
				</td>
				<td class="w-25">
				<c:choose>
					<c:when test="${boardDto.writer!=null}">
					${boardDto.writer}
					</c:when>
					<c:otherwise>
					(탈퇴한 사용자)
					</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</div>	
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>