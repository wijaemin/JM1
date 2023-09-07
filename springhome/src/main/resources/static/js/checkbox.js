$(function(){
    //전체선택과 개별체크박스에 대한 이벤트 구현
    
    
    $(".delete-btn").hide();
    
    
    
    //전체 선택
    $(".check-all").change(function(){
        var check=$(this).prop("checked");
            $(".check-all,.check-item").prop("checked",check);
            if(check){
                //$(".delete-btn").css("display","inline-block");
                //$(".delete-btn").show();
                $(".delete-btn").fadeIn("fast");
                //$(".delete-btn").slideDown();
                
            }
            else{
				//$(".delete-btn").hide();
				$(".delete-btn").fadeOut("fast");
				//$(".delete-btn").slideUp();
            }
    });
    
    //개별체크박스
    $(".check-item").change(function(){
        // var allCheck = 개별체크박스개수 ==체크된개별체크박스개수;
        // var allCheck=$(".check-item").length == $(".check-item:checked").length;
        var allCheck=$(".check-item").length == $(".check-item").filter(":checked").length;
        $(".check-all").prop("checked",allCheck);
        
        if($(".check-item").filter(":checked").length >0 ){
			$(".delete-btn").fadeIn("fast");
		}
		else{
			$(".delete-btn").fadeOut("fast");
		}
    });
    
    $(".delete-form").submit(function(e){
		return confirm("정말삭제하시겠습니까?");
		
	});
    
});