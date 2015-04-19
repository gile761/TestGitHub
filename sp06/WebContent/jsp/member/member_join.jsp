<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<script src="./js/jquery.js"></script>
<script src="./js/m.js"></script>
</head>
<body>
 <form method="post" action="member_join_ok.do" 
 onsubmit="return join_check();">
  <table align="center" border="1">
   <tr>
    <th colspan="2">회원가입</th>
   </tr>
   <tr>
    <th>회원아이디</th>
    <td>
    <input type="text" name="join_id" id="join_id"
    size="14" />
    </td>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td>
    <input type="password" name="join_pwd" id="join_pwd"
    size="14" />
    </td>
   </tr>
   <tr>
    <th>비밀번호확인</th>
    <td>
    <input type="password" name="join_pwd2" id="join_pwd2"
    size="14" />
    </td>
   </tr>
   <tr>
    <th>회원이름</th>
    <td>
    <input name="join_name" id="join_name" size="14" />
    </td>
   </tr>
   <tr>
    <th>휴대전화</th>
    <td>
    <select name="phone01">
    <c:forEach var="p" items="${phone}">
    <option value="${p}">${p}</option>
    </c:forEach>
    </select>-<input name="phone02" id="phone02" size="4"
    maxlength="4" />-<input name="phone03" id="phone03"
    size="4" maxlength="4" />
    <%-- maxlength="4"로 지정하면 입력박스에 4자까지만 입력
    가능하다. --%>
    </td>
   </tr>
   <tr>
    <th>회원주소</th>
    <td>
    <input name="join_addr" id="join_addr" size="36" />
    </td>
   </tr>
   <tr>
    <th colspan="2">
    <input type="submit" value="회원가입" />
    <input type="reset" value="가입취소" 
    onclick="$('#join_id').focus();" />
    </th>
   </tr>
  </table>
 </form>
</body>
</html>