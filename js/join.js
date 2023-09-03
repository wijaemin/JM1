function checkMemberId(){
    var input=document.querySelector("[name=memberId]");
    var regex=/^[a-z][a-z0-9-_]{4,19}$/;
    var isValid=regex.test(input.value);

    input.classList.remove("success","fail");
    input.classList.add(isValid ? "success" : "fail");
}
function checkMemberPw(){
    var input=document.querySelector("[name=memberPw]");
    var regex=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
    var isValid=regex.test(input.value);

    input.classList.remove("success","fail");
    input.classList.add(isValid ? "success" : "fail");
}
function checkMemberNickname(){
    var input=document.querySelector("[name=memberNickname]");
    var regex=/^[가-힣0-9]{1,10}$/;
    var isValid=regex.test(input.value);

    input.classList.remove("success","fail");
    input.classList.add(isValid ? "success" : "fail");
}
function checkForm(){
    var r1=checkMemberId();
    var r2=checkMemberPw();
    var r3=checkMemberNickname();
        
}