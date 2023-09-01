function checkBoardTitle(){
    var input=document.querySelector("[name=boardTitle]");

    var isValid=input.value.length>0 && input.value.length <=1000;
    input.classList.remove("fail");
    if(isValid==false){
        input.classList.add("fail");
        return false;
    }
        return true;
}
function checkBoardContent(){
    var textarea=document.querySelector("[name=boardContent]")
    var isValid=textarea.value.length>0 && textarea.value.length<=1000;
    var len=document.querySelector(".len");
    len.textContent=textarea.value.length;
    textarea.classList.remove("fail");
    len.classList.remove("red");
    if(isValid==false){
        textarea.classList.add("fail");
        len.classList.add("red");
        return false;
    }
    return true;
}
function checkForm(){
    var r1= checkBoardTitle();
    var r2= checkBoardContent();
    console.log(r1, r2);
    return false;

}
