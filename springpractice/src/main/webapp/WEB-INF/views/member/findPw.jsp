<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form action="findPw" method="post">
	<div class="container w-400">
		<div class="row">
			<h1>��й�ȣ ã��</h1>
		</div>
		<div class="row">
		<input type="text" name="email" class="form-input w-100" placeholder="�̸���">
		</div>
		<div class="row">
			<button class="btn w-100 btn-positive">��й�ȣ ã��</button>
		</div>
	</div>

</form>
<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>