<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 폼</title>
<link rel="stylesheet" type="text/css" href="./css/m.css" />
<script src="./js/jquery.js"></script>
<script>
 function login_check(){
	 if($.trim($("#login_id").val())==""){
		 alert("로그인 아이디를 입력하세요!");
		 $("#login_id").val("").focus();
		 return false;
	 }
	 if($.trim($("#login_pwd").val())==""){
		 alert("로그인 비번을 입력하세요!");
		 $("#login_pwd").val("").focus();
		 return false;
	 }
 }
</script>
</head>
<body>
 <form method="post" action="member_login_ok.do"
 onsubmit="return login_check();">
  <table align="center" border="1">
   <tr>
    <th colspan="3">로그인</th>
   </tr>
   <tr>
    <th>아이디</th>
    <td>
    <input type="text" name="login_id" id="login_id"
    size="14" tabindex="1"/>
     <%-- tabindex속성을 1로 주면 키보드의 탭키를 눌렀을때 첫번째
    로 포커스를 가지고,비번입력창을 2로 주면 두번째로 포커스를
    가진다. --%>
    </td>
    <th rowspan="2">
    <input type="submit" value="로그인" class="input_s" />   
    </th>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td>
    <input type="password" name="login_pwd" id="login_pwd"
    size="14" tabindex="2" />
    </td>
   </tr>
   <tr>
    <th colspan="3">
    <input type="button" value="회원가입"
    onclick="location='member_join.do'" />
    <input type="button" value="비번찾기" />
    </th>
   </tr>
  </table>
 </form>
</body>
</html>