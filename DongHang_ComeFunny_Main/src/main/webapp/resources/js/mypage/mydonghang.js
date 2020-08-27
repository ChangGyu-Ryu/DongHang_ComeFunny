/**
 * 나의 동행
 */

//checkBox 전체 체크 
$(document).ready(function () {
	
	$("#deleteChkAll").click(function(){
		if($(this).prop("checked")){
			$(".deleteChk").prop("checked", true);
		}else{
			$(".deleteChk").prop("checked", false);
		}		
		
	})
})
