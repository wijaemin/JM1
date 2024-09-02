<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<style>
	.note-viewer{
		line-height: 2 !important;
	}
</style>

<!-- 댓글과 관련된 처리를 하는 JQuery 코드 구현-->
<script>
$(function(){
	//목표: 댓글 등록을 누르면 입력정보로 ajax 통신을 통해 댓글을 등록
	//(주의)form은 전송이 되면 안된다
	
	
	$(".reply-insert-form").submit(function(e){
		//this == e.target ==폼(form)
		
		//입력 검사 코드는 스킵
		
		//기본 이벤트 차단
		e.preventDefault();
		
		//비동기 통신
		$.ajax({
			//url:"http://localhost:8080/rest/reply/insert",
			url:"/rest/reply/insert",
			method:"post",
			data:$(e.target).serialize(),
			success:function(response){
				//console.log("성공");
				$("[name=content]").val("");
			}
			
			
		});
		
	});
});




</script>

<div class="container w-700">
	<div class="row">
		<h1>${boardDto.no}번 게시글</h1>
	</div>
	
	<div class="row left">
		<h3>
			<i class="fa-solid fa-user"></i>
			${memberDto.nickname}
			<%-- 탈퇴한 사용자가 아닐 경우 닉네임을 옆에 추가로 출력 --%>
			<c:if test="${boardDto != null}">
			(${boardDto.writerString})
			</c:if>
		</h3>
	</div>
	<div class="row right">
				<fmt:formatDate value="${boardDto.createdAt}" pattern="y년 M월 d일 E a h시 m분 s초"/>
	</div>
	<div class="row right">
		<i class="fa-solid fa-eye"></i> 
		${boardDto.readcount}
		&nbsp;&nbsp;
		<i class="fa-regular fa-heart red"></i> 
		<span>${boardDto.likecount}</span>
		&nbsp;&nbsp;
		<i class="fa-solid fa-comment blue"></i> 
		${boardDto.replycount}
	</div>
	<div class="row left">
		<h2>${boardDto.title}</h2>
	</div>
	<%--게시글 내용(본문) --%>
	<div class="row left note-viewer" style="min-height:250px">
		${boardDto.content}
	</div>
	
	
	<%-- 댓글과 관련된 화면이 작성될 위치 --%>
	<div class = "row left">
		<form class="reply-insert-form">
			<input type="hidden" name="origin" value="${boardDto.no}">
			
			
			<div class="row">
				<textarea name="content" class="form-input w-100" rows="4"></textarea>
			</div>
			<div class="row">
				<button class="btn btn-positive w-100">
				<i class="fa-solid fa-pen"></i>
				등록하기
				</button>
			</div>
		</form>
	</div>
	
	<div class="row left">
		
		<div class="row flex-container">
			<div class="w-75">
				<div class="row left">
					<h1 class="db이름">작성자</h1>
				</div>
				<div class="row left">
				<pre class="db이름">내용</pre>
				</div>
				<div class="row left">
				<span class="db이름">yyyy-MM-dd HH:mm:ss</span>
				</div>
			</div>
			<div class="w-25">
				<div class="row">
					<button class="btn btn-positive">
						<i class="fa-solid fa-edit"></i>
					</button>
				</div>
				<div class="row">
					<button class="btn btn-negative">
						<i class="fa-solid fa-trash"></i>
					</button>
				</div>
			
			</div>
		</div>
		
	</div>
	
	
	
	<%--각종 버튼 위치 --%>
	<div class="row right">
		<%-- 회원일 때만 글쓰기,수정,삭제가 나와야 한다 --%>
		<c:if test="${sessionScope.email != null}">
		<a class="btn btn-positive" href="write">
			<i class="fa-solid fa-pen"></i>
			새글
		</a>
		<a class="btn btn-positive" href="write?boardParent=${boardDto.no}">
			<i class="fa-solid fa-comment"></i>
			답글
		</a>
		
		<%-- 수정/삭제는 소유자일 경우만 나와야 한다 --%>
		<c:if test="${sessionScope.email == boardDto.writer}">
		<a class="btn btn-negative" href="edit?no=${boardDto.no}">
			<i class="fa-solid fa-pen-to-square"></i>
			수정
		</a>
		<a class="btn btn-negative" href="delete?no=${boardDto.no}">
			<i class="fa-solid fa-trash"></i>
			삭제
		</a>
		</c:if>
		</c:if>
		<a class="btn" href="list">
			<i class="fa-solid fa-list"></i>
			목록
		</a>
	</div>
	

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>