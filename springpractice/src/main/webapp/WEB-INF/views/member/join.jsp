<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<style>
    input[name=addr1]{
        border-bottom: none;
    }

</style>

	<form action="join" method="post" autocomplete="off">
        <div class="container w-500">
            <div class="row">
                <h2>회원가입</h2>
            </div>
            <div class="row left">
                <label>이메일<span class="important">*</span></label>
                <input class="form-input w-100" type="text" name="email" placeholder="test@naver.com">
            </div>
            <div class="row left">
                <label>비밀번호<span class="important">*</span></label>
                <input class="form-input w-100" type="password" name="password" placeholder="영문 대소문자+숫자+특수문자 반드시 포함 8~16자 이내">
            </div>
            <div class="row left">
                <label>닉네임<span class="important">*</span></label>
                <input class="form-input w-100" type="text" name="nickname" placeholder="한글 또는 숫자 2~10자 이내">
            </div>
            <div class="row left">
                <label>연락처</label>
                <input class="form-input w-100" type="tel" name="contact" placeholder="- 제외하고 입력">
            </div>
            <div class="row left">
                <label>생년월일</label>
                <input class="form-input w-100" type="date" name="birth">
            </div>
            <div class="row left">
                <label style="display: block;">주소</label>
                <input class="form-input" text="text" name="post" 
                placeholder="우편번호" size="6" maxlength="6">
                <button type="button" class="btn">우편번호 찾기</button>
            </div>
            <div class="row">
                <input class="form-input w-100" type="text" name="addr1" placeholder="기본주소">
                <input class="form-input w-100" type="text" name="addr2" placeholder="상세주소">
            </div>
            <!-- <div class="row">
            </div> -->
            <div class="row">
                <button type="submit" class="btn btn-positive w-100">가입하기</button>
            </div>
        </div>
	</form>



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>