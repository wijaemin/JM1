<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<!-- jquery cdn -->
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script>
    $(function(){
        //전체 선택과 개별 체크박스에 대한 이벤트 구현
		//$(".delete-btn").css("display","none");
        $(".delete-btn").hide();
        //전체 선택
        $(".check-all").change(function(){
            var check = $(this).prop("checked");
            $(".check-all, .check-item").prop("checked",check);
            
            if(check){
            	//$(".delete-btn").css("display","inline-block");
            	//$(".delete-btn").show();
            	$(".delete-btn").fadeIn();
            	//$(".delete-btn").slideDown();
            }
            else{
            	//$(".delete-btn").css("display","none");
            	//$(".delete-btn").hide();
            	$(".delete-btn").fadeOut();
            	//$(".delete-btn").slideUp();
            }
        });

        //개별 체크박스
        $(".check-item").change(function(){
            // var allCheck= 개별체크박스 개수 == 체크된 개별체크박스 개수;
            // var allCheck = $(".check-item").length == $(".check-item:checked").length;
            var allCheck = $(".check-item").length == $(".check-item").filter(":checked").length;
            $(".check-all").prop("checked",allCheck);
			
            if($(".check-item").filter(":checked").length>0){
            	$(".delete-btn").fadeIn();
            }
            else{
            	$(".delete-btn").fadeOut();
            }
        });
    });
</script>
<div class="container w-800">

	<div class="row">
	<h1>하이 게시판</h1>
	</div>
	
	<!-- 폼 시작 -->
	<form action="deleteByAdmin" method="post">
	
	<c:if test="${sessionScope.email !=null}">
	
	<div class="row right">
		<button type="submit" class="btn btn-negative delete-btn">
			<i class="fa-solid fa-trash"></i>
			일괄삭제
		</button>
		<a class="btn w-200" href="/board/write">
			<h4>글쓰기</h4>
		</a>
	</div>
	</c:if>
	
	<!-- 검색일 경우 검색어를 추가로 출력 -->
	<!-- (참고) 논리 반환값을 가지는 getter 메소드는 get이 아니라 is로 시작-->
	<c:if test="${vo.search}">
		<h3>&quot;${vo.keyword}&quot;에 대한 검색 결과</h3>
	</c:if>
	<table class="table table-border" width="1000">
			<thead>
				<tr>
					<th>
						<!-- 전체 선택 체크박스 -->
						<input type="checkbox" class="check-all">
					</th>
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
						<!-- 개별 체크 박스 -->
						<input type="checkbox" class="check-item" name="no" value="${boardListDto.no}">
					</td>
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
	</table>
	</form>
	<!-- 폼 종료 -->


	<!-- 페이지 네비게이터 출력 -->

	<div class="row page-navigator">
	<!-- 이전 버튼 -->
		
		<c:if test="${!vo.first}">
					<a href="list?${vo.prevQueryString}">&lt;</a>	
		</c:if>
	<!-- 숫자 버튼 -->
	<c:forEach var="i" begin="${vo.begin}" end="${vo.end}" step="1">
		<c:choose>
			<c:when test="${vo.page==i}">
				<a class="on">${i}</a>
			</c:when>
			<c:otherwise>
				<a href="list?${vo.getQueryString(i)}">${i}</a>	
			</c:otherwise>	
		</c:choose>
	</c:forEach>
	
	<!-- 다음 버튼 -->
		<c:if test="${!vo.last}"><!-- 마지막이 아니라면  -->
				<a href="list?${vo.nextQueryString}">&gt;</a>	
		</c:if>
	
	</div>
	<!-- 검색창 -->
	<form action="list" method="get">
	<div class="row">
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
		
		<input type="search" name="keyword" class="form-input" placeholder="검색어 입력" value="${param.keyword}" required>
		<button class="btn btn-positive">검색</button>
	</div>	
	</form>

</div>

<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>