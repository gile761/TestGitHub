<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보수정</title>
<script src="./js/jquery.js"></script>
<script src="./js/m.js"></script>
</head>
<body>
 <form method="post" action="member_edit_ok.do" 
 onsubmit="return edit_check();">
  <table align="center" border="1">
   <tr>
    <th colspan="2">정보수정</th>
   </tr>
   <tr>
    <th>회원아이디</th>
    <td>${id}</td>
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
    <input name="join_name" id="join_name" size="14" 
    value="${eb.join_name}" />
    </td>
   </tr>
   <tr>
    <th>휴대전화</th>
    <td>
    <select name="phone01">
    <c:forEach var="p" items="${phone}">
    <option value="${p}"
    <c:if test="${eb.phone01 == p}">
    ${'selected'}</c:if>>${p}</option>
    </c:forEach>
    </select>-<input name="phone02" id="phone02" size="4"
    maxlength="4" value="${eb.phone02}" />-<input name="phone03" id="phone03"
    size="4" maxlength="4" value="${eb.phone03}" />
    <%-- maxlength="4"로 지정하면 입력박스에 4자까지만 입력
    가능하다. --%>
    </td>
   </tr>
   <tr>
    <th>회원주소</th>
    <td>
    <input name="join_addr" id="join_addr" size="36"
    value="${eb.join_addr}" />
    </td>
   </tr>
   <tr>
    <th colspan="2">
    <input type="submit" value="정보수정" />
    <input type="reset" value="수정취소" 
    onclick="$('#join_pwd').focus();" />
    </th>
   </tr>
  </table>
 </form>
</body>
</html>