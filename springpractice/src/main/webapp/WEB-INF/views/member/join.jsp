<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>


<style>
    input[name=addr1]{
        border-bottom: none;
    }

    /* 
        진행바 디자인
    */
    .progressbar{
        width: 100%;
        height: 5px;
    }
    .progressbar > .gauge{
        width: 0%;
        height: 100%;
        background: rgb(131,58,180);
        background: linear-gradient(90deg, rgba(131,58,180,1) 0%, rgba(253,29,29,1) 50%, rgba(252,176,69,1) 100%);

        transition: width 0.1s ease-out;
    }
</style>
<script src="/js/join.js"></script>
<script src="/js/address.js"></script>
<script src="/js/multipage.js"></script>
<script src="/js/progressbar.js"></script>
<!-- daum 우편 API cdn -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<form  class="join-form" action="join" method="post" autocomplete="off">

        <div class="container w-600">
            <div class="row">
                <h1>회원 정보 입력</h1>
            </div>
            
            <!-- 전체 진행단계를 알 수 있는 게이지 출력 -->
             <div class="row">
                <div class="progressbar">
                    <div class="gauge"></div>
                </div>
             </div>

            <div class="row page">
                <div class="row">
                    <h2>1단계 : 이메일, 비밀번호</h2>
                </div>
                <div class="row left">
                    <label>이메일</label>
                    <input type="text" name="email" placeholder="testuser@kh.com" 
                        class="form-input w-100">
                    <div class="success-feedback">올바른 이메일 형식입니다</div>
                    <div class="fail-feedback">잘못된 이메일 형식입니다</div>
                    <div class="fail2-feedback">중복된 이메일입니다</div>
                </div>
                <div class="row left">
                    <label>비밀번호</label>
                    <input type="password" name="password" 
                    placeholder="영문 대소문자+숫자+특수문자 반드시 포함 8~16자" 
                    class="form-input w-100">
                    <div class="success-feedback">올바른 비밀번호 형식입니다</div>
                    <div class="fail-feedback">잘못된 비밀번호 형식입니다</div>
                </div>
                <div class="row left">
                    <label>비밀번호 확인</label>
                    <input type="password" id="password-check" 
                        placeholder="비밀번호 재입력" 
                        class="form-input w-100">
                    <div class="success-feedback">비밀번호가 일치합니다</div>
                    <div class="fail-feedback">비밀번호가 일치하지 않습니다</div>
                    <div class="fail2-feedback">비밀번호를 먼저 작성하세요</div>
                </div>

                <!-- 버튼처리 -->
                <div class="row">
                    <button type="button" class="btn btn-prev">
                        <i class="fa-solid fa-arrow-left"></i>
                    </button>
                    <button type="button" class="btn btn-next">
                        <i class="fa-solid fa-arrow-right"></i>
                    </button>
                </div>
            </div>
            <div class="row page">
                <div class="row">
                    <h2>2단계 : 닉네임, 전화번호, 생년월일</h2>
                </div>
                <div class="row left">
                    <label>닉네임</label>
                    <input type= "text" name="nickname" class="form-input w-100" 
                        placeholder="한글 또는 숫자 2~10자 이내">
                 <div class="success-feedback">올바른 닉네임 형식입니다</div>
                 <div class="fail-feedback">잘못된 닉네임 형식입니다</div>
                 <div class="fail2-feedback">이미 사용하고있는 닉네임입니다</div>
                </div>
                <div class="row left">
                    <label>전화번호</label>
                    <input type="tel" name="contact" placeholder="010XXXXXXXX(-제외)"
                        class="form-input w-100">
                    <div class="fail-feedback">전화번호 형식이 올바르지 않습니다</div>
    
                </div>
                <div class="row left">
                    <label>생년월일</label>
                    <input type="date" name="birth" class="form-input w-100">
                   <div class="fail-feedback">잘못된 날짜를 선택하셨습니다</div>
                </div>
                <!-- 버튼처리 -->
                <button type="button" class="btn btn-prev">
                    <i class="fa-solid fa-arrow-left"></i>
                </button>
                <button type="button" class="btn btn-next">
                    <i class="fa-solid fa-arrow-right"></i>
                </button>
            </div>
            <div class="row page">
                <div class="row">
                    <h2>3단계 : 주소</h2>
                </div>
                <div class="row left">
                    <label style="display: block;">주소</label>
                    <input type="text" name="post" placeholder="우편번호" 
                        class="form-input post-search" size="6" maxlength="6" 
                        readonly>
                    <button type="button" class="btn post-search">
                        <i class="fa-solid fa-magnifying-glass"></i>
                    </button>
    
                    <input type="text" name="addr1"  placeholder="기본주소" 
                    class="form-input post-search w-100 mt-10" 
                    readonly>
                    <input type="text" name="addr2"  placeholder="상세주소" 
                    class="form-input w-100 mt-10">
                </div>

                <!-- 버튼처리 -->
                <button type="button" class="btn btn-prev">
                    <i class="fa-solid fa-arrow-left"></i>
                </button>
                <button type="button" class="btn btn-next">
                    <i class="fa-solid fa-arrow-right"></i>
                </button>

                <div class="row left">
                    <button class="btn btn-positive w-100">가입하기</button>
                </div>
            </div>
		</div>
</form>
<!-- 	<form action="join" method="post" autocomplete="off">
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
            <div class="row">
            </div>
            <div class="row">
                <button type="submit" class="btn btn-positive w-100">가입하기</button>
            </div>
        </div>
	</form> -->



<jsp:include page="/WEB-INF/views/template/footer.jsp"></jsp:include>