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
				loadList();//목록 갱신
			}
			
			
		});
		
	});
	
	//목록은 페이지가 로딩되면 바로 불러오기
	//등록이 완료 되도 불러오기
	//여러 군데에서 사용할 수 있도록 함수 형태로 구현
	//목록을 모두 지우고 전부 다 새로 불러온다
	loadList();
	
	//목록을 불러온 뒤 추가로 해야할 것
	//내 글에만 수정/삭제 버튼이 나오도록 처리
	//게시글 작성자가 쓴 댓글에 추가 표시
	//수정 버튼을 누르면 화면에 변화를 주도록 처리
	//삭제 버튼을 누르면 확인창 출력후 삭제하도록 처리

	function loadList(){
		//JavaScript로 no(게시글 번호)라는 이름의 파라미터 값 읽기
		var params= new URLSearchParams(location.search);
		var no=params.get("no");
		
		//(중요) 로그인한 사용자의 정보를 EL을 이용하여 저장(매우 위험)
		var email = "${sessionScope.email}";
		
		//비동기 통신으로 화면 갱신
		$.ajax({
			//url:"https://localhost:8080/rest/reply/list",
			url:"/rest/reply/list",
			method:"post",
			data:{origin: no},
			success:function(response){
				//화면 청소
				//$("reply-list").remove();//자기 자신까지 삭제(하면X);
				$(".reply-list").empty();//자기 자신을 제외한 내부 코드 삭제				
				//response는 댓글목록(JSON 방식)
				for(var i=0;i < response.length;i++){
					var reply =response[i];
					
					var template = $("#reply-template").html();
					var htmlTemplate = $.parseHTML(template);
					
					//작성자를 표시할 때 다음과 같이 로직을 추가
					//1.탈퇴한 사용자는 빈칸이 아니라 "탈퇴한 사용자"로 처리
					$(htmlTemplate).find(".writer").text(reply.writer||"탈퇴한 사용자");
					$(htmlTemplate).find(".content").text(reply.content);
					$(htmlTemplate).find(".createdAt").text(reply.createdAt);
					
					//비회원일때, 작성자가 아닐 때
					//댓글 지우기
					if(email.length == 0 || email != reply.writer){
						$(htmlTemplate).find(".w-25").empty();
					}
					
					//만드는 시점에 이벤트 설정
					//-반복문의 데이터 사용 불가(위치 다름)
					//지금과 같이 버튼 내부에 태그가 더 있을 때,
					//	this와 e.target은 다를 수 있다
					//	(this는 주인공, e.target은 실제대상)
					$(htmlTemplate).find(".btn-delete")
						.attr("data-reply-no",reply.no)
						.click(function(e){
						//var replyNo=$(this).data("reply-no");
						var replyNo=$(this).attr("data-reply-no");
						//var replyNo=$(e.target).data("reply-no");
						//var replyNo=$(e.target).attr("data-reply-no");
						$.ajax({
							url:"/rest/reply/delete",
							method:"post",
							data:{no: replyNo},
							success:function(response){
								loadList();
							},
						});
					});
					
					//수정 버튼
					//편집 상태의 템플릿을 만들어서 추가
					//전환 시 작성된 값들을 입력창으로 이동 시켜야함
					//전송 가능한 form과 취소 버튼을 구현
					//수정 시 서버로 글번호와 글내용만 전달하면 됨
					
					$(htmlTemplate).find(".btn-edit")
									.attr("data-reply-no",reply.no)
									.click(function(){
						//this == 수정 버튼
						var editTemplate= $("#reply-edit-template").html();
						var editHtmlTemplate= $.parseHTML(editTemplate);
						
						//value설정
						var replyNo=$(this).attr("data-reply-no");
						var replyContent=$(this).parents(".view-container")
												.find(".content").text();
						$(editHtmlTemplate).find("[name=no]").val(replyNo);
						$(editHtmlTemplate).find("[name=content]").val(replyContent);
						
						
						//취소버튼 구현
						$(editHtmlTemplate).find(".btn-cancel")
											.click(function(){
							//this == 취소버튼
							$(this).parents(".edit-container")
									.prev(".view-container").show();
							$(this).parents(".edit-container").remove();
						});
						
						
						//완료(등록) 버튼
						//editHtmlTemplate 자체가 form이므로 추가 탐색을 하지 않음
						$(editHtmlTemplate).submit(function(e){
							//검사코드(미입력)												
							
							//기본 이벤트 차단
							e.preventDefault();
							
							$.ajax({
								url:"/rest/reply/edit",
								method:"post",
								//data:{no: ?, content: ?},
								data:$(e.target).serialize(),//form으로 하면 데이터  한꺼번에 serialize()로 보낼 수 있음
								success:function(response){
									loadList();	
								}
							});
						});
						
						
						//화면 배치
						$(this).parents(".view-container")
								.hide()
								.after(editHtmlTemplate);
						
						
						
					});
					
					
					
					$(".reply-list").append(htmlTemplate);
					
				}
			},
		});
	}
});

</script>
<script id="reply-template" type="text/template">
<div class="row flex-container view-container">
  <div class="w-75">
	<div class="row left">
		<h1 class="writer">작성자</h1>
	</div>
	<div class="row left">
	<pre class="content">내용</pre>
	</div>
	<div class="row left">
	<span class="createdAt">yyyy-MM-dd HH:mm:ss</span>
	</div>
  </div>
  <div class="w-25">
	<div class="row">
		<button class="btn btn-edit btn-positive">
			<i class="fa-solid fa-edit"></i>
		</button>
	</div>
	<div class="row">
		<button class="btn btn-delete btn-negative">
			<i class="fa-solid fa-trash"></i>
		</button>
	</div>

  </div>
</div>
</script>
<script id="reply-edit-template" type="text/template">
	<form class="reply-edit-form edit-container">
	<input type="hidden" name="no" value="?">
	<div class="row flex-container">
		<div class="w-75">
			<textarea name="content" class="form-input w-100" rows="4">?</textarea>
		</div>
		<div class="w-25">
			<div class="row">
				<button type="submit" class="btn btn-positive">등록</button>
			</div>
			<div class="row">
				<button type="button" class="btn btn-negative btn-cancel">취소</button>
			</div>
		</div>
	</div>
	</form>
</script>

<div class="container w-800">
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
	<c:if test="${sessionScope.email!=null}">
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
	</c:if>
	<%-- 비동기 통신에서의 form은 전송하는 목적이 아니고
		 데이터를 serialize(압축)시켜주는 역할을 한다
		 전송할 데이터를 손쉽게 만들어주는 역할
	  --%>
	<%-- 댓글 목록이 표시될 영역 --%>
	<div class="row left reply-list"></div>
	
	<div class="row left">
		
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