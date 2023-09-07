$(function(){


    var status={
        id:false,
        pw:false,
        pwCheck:false,
        nickname:false,
        email:false,
        contact:false,
        birth:false,
        address:false,
        ok:function(){
            return this.id && this.pw && this.pwCheck &&this.nickname && this.email && this.contact && this.birth && this.address;
        }
    };



    $("[name=memberId]").blur(function(){
        var regex=/^[a-z][a-z0-9-_]{4,19}$/;
        var inputId=$(this).val();
        
        var isValid=regex.test(inputId);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.id=isValid;
    });

    $("[name=memberPw]").blur(function(){
        var regex=/^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$])[A-Za-z0-9!@#$]{8,16}$/;
        var inputPw=$(this).val();
        
        var isValid=regex.test(inputPw);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.pw=isValid;
    });

    $("#password-check").blur(function(){
        var inputPw=$("[name=memberPw]").val();
        var checkPw=$(this).val();

        var isValid=inputPw==checkPw;

        $(this).removeClass("success fail fail2");
        if(inputPw.length==0){
            $(this).addClass("fail2");
            status.pwCheck=false;

        }
        else if(isValid){
            $(this).addClass("success");
            status.pwCheck=true;
        }
        else{
            $(this).addClass("fail");
            status.pwCheck=false;
        }
    });

    $("[name=memberNickname]").blur(function(){
        var regex=/^[가-힣0-9]{1,10}$/;
        var inputNickname=$(this).val();
        
        var isValid=regex.test(inputNickname);
        $(this).removeClass("success fail fail2");
        if(isValid){
            $(this).addClass("success");
            status.nickname=true;
        }
        else{
            $(this).addClass("fail");
            status.nickname=false;
        }
    });
    $("[name=memberEmail]").blur(function(){
        var regex=/^(.*?)@(.*?)$/;
        var inputEmail=$(this).val();
        
        var isValid=$(this).val().length==0 || regex.test(inputEmail);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.email=isValid;
    });
    $("[name=memberContact]").blur(function(){
        var regex = /^010[1-9][0-9]{7}$/;
        var inputContact=$(this).val();
        
        var isValid=$(this).val().length==0 || regex.test(inputContact);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.contact=isValid;
    });
    $("[name=memberBirth]").blur(function(){
        var regex=/^(19[0-9]{2}|20[0-9]{2})-(((0[13578]|1[02])-(0[1-9]|1[0-9]|2[0-9]|3[01]))|((0[469]|11)-(0[1-9]|1[0-9]|2[0-9]|30))|((02)-(0[1-9]|1[0-9]|2[0-9])))$/;
        var inputBirth=$(this).val();
        
        var isValid=$(this).val().length==0 || regex.test(inputBirth);
        $(this).removeClass("success fail");
        $(this).addClass(isValid ? "success" : "fail");
        status.birth=isValid;
    });



    $("[name=memberPost],[name=memberAddr1],[name=memberAddr2]").blur(function(){
        var inputPost=$("[name=memberPost]").val();
        var inputAddr1=$("[name=memberAddr1]").val();
        var inputAddr2=$("[name=memberAddr2]").val();

        var isBlank = inputPost.length==0 && inputAddr1.length==0 && inputAddr2.length ==0;
        var isFill = inputPost.length>0 && inputAddr1.length>0 && inputAddr2.length >0;

        var isValid= isBlank || isFill;

        $("[name=memberPost]").removeClass("success fail");
        $("[name=memberAddr1]").removeClass("success fail");
        $("[name=memberAddr2]").removeClass("success fail");

        $("[name=memberPost]").addClass(isValid ? "success" : "fail");
        $("[name=memberAddr1]").addClass(isValid ? "success" : "fail");
        $("[name=memberAddr2]").addClass(isValid ? "success" : "fail");

        status.address=isValid;
    });

    $(".join-form").submit(function(e){
        // $(".form-input").blur();//버튼 눌렀을 때 메세지 뜨게 하기
        //status를 확인
        console.table(status);
        // console.log(status.ok());
        if(status.ok()==false){
            e.preventDefault();
        }
        

    });



    });