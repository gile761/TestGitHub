<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메인화면</title>
</head>
<body>
 <form method="post" action="logout.do">
  <table align="center" border="1">
   <tr>
    <th>메인화면</th>
   </tr>
   <tr>
    <th>
    <input type="button" value="정보수정"
    onclick="location='member_edit.do'" />
    <input type="button" value="회원탈퇴"
    onclick="location='member_del.do'" />
    <input type="submit" value="로그아웃" />
    </th>
   </tr>
   <tr>
    <th>${name}님 로그인을 환영합니다!</th>
   </tr>
  </table>
 </form>
</body>
</html>