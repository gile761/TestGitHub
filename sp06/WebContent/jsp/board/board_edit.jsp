<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>aop 게시판</title>
<script src="./js/jquery.js"></script>
<script src="./js/board.js"></script>
</head>
<body>
 <form method="post" action="board_edit_ok.do"
 onsubmit="return check();">
 <input type="hidden" name="board_no" value="${b.board_no}" />
 <input type="hidden" name="page" value="${page}" />
  <table align="center" border="1">
   <tr>
    <th colspan="2">aop 게시판 수정</th>
   </tr>
   <tr>
    <th>이름</th>
    <td>
    <input name="board_name" id="board_name" size="14" 
    value="${b.board_name}" />
    </td>
   </tr>
   <tr>
    <th>제목</th>
    <td>
    <input name="board_title" id="board_title" size="36" 
    value="${b.board_title}" />
    </td>
   </tr>
   <tr>
    <th>비밀번호</th>
    <td>
    <input type="password" name="board_pwd" id="board_pwd"
    size="14" />
    </td>
   </tr>
   <tr>
    <th>내용</th>
    <td>
   <textarea name="board_cont" id="board_cont"
   rows="10" cols="34">${b.board_cont}</textarea>
    </td>
   </tr>
   <tr>
   <th colspan="2">
   <input type="submit" value="수정" />
   <input type="reset" value="취소" 
   onclick="$('#board_name').focus();" />
   <input type="button" value="목록"
   onclick="location='board_list.do?page=${page}'" />
   </th>
   </tr>
  </table>
 </form>
</body>
</html>