/**
 *  m.js
 */

function join_check(){
	if($.trim($("#join_id").val())==""){
		alert("회원아이디를 입력하세요!");
		$("#join_id").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#join_pwd").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd2").val())==""){
		alert("비밀번호 확인을 입력하세요!");
		$("#join_pwd2").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd").val()) != 
		   $.trim($("#join_pwd2").val())){
		alert("비번이 일치하지 않습니다!");
		$("#join_pwd").val("");
		$("#join_pwd2").val("");
		$("#join_pwd").focus();
		return false;
	}
	if($.trim($("#join_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#join_name").val("").focus();
		return false;
	}
	if($.trim($("#phone02").val())==""){
		alert("폰번호를 입력하세요!");
		$("#phone02").val("").focus();
		return false;
	}
	if($.trim($("#phone03").val())==""){
		alert("폰번호를 입력하세요!");
		$("#phone03").val("").focus();
		return false;
	}
	if($.trim($("#join_addr").val())==""){
		alert("회원주소를 입력하세요!");
		$("#join_addr").val("").focus();
		return false;
	}
}


function edit_check(){
	if($.trim($("#join_pwd").val())==""){
		alert("비밀번호를 입력하세요!");
		$("#join_pwd").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd2").val())==""){
		alert("비밀번호 확인을 입력하세요!");
		$("#join_pwd2").val("").focus();
		return false;
	}
	if($.trim($("#join_pwd").val()) != 
		   $.trim($("#join_pwd2").val())){
		alert("비번이 일치하지 않습니다!");
		$("#join_pwd").val("");
		$("#join_pwd2").val("");
		$("#join_pwd").focus();
		return false;
	}
	if($.trim($("#join_name").val())==""){
		alert("회원이름을 입력하세요!");
		$("#join_name").val("").focus();
		return false;
	}
	if($.trim($("#phone02").val())==""){
		alert("폰번호를 입력하세요!");
		$("#phone02").val("").focus();
		return false;
	}
	if($.trim($("#phone03").val())==""){
		alert("폰번호를 입력하세요!");
		$("#phone03").val("").focus();
		return false;
	}
	if($.trim($("#join_addr").val())==""){
		alert("회원주소를 입력하세요!");
		$("#join_addr").val("").focus();
		return false;
	}
}






