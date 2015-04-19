<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내용보기</title>
</head>
<body>
 <table align="center" border="1">
  <tr>
   <th colspan="2">내용보기</th>
  </tr>
  <tr>
   <th>제목</th>
   <td>${b.board_title}</td>
  </tr>
  <tr>
   <th>내용</th>
   <td>${cont}</td>
  </tr>
  <tr>
   <th>조회수</th>
   <td>${b.board_hit}</td>
  </tr>
  <tr>
   <th colspan="2">
   <input type="button" value="답변"
   onclick="location=
'board_cont.do?no=${b.board_no}&page=${page}&state=reply'" />

<input type="button" value="수정"
   onclick="location=
'board_cont.do?no=${b.board_no}&page=${page}&state=edit'" />

<input type="button" value="삭제"
   onclick="location=
'board_cont.do?no=${b.board_no}&page=${page}&state=del'" />  

<input type="button" value="목록"
   onclick="location=
'board_list.do?page=${page}'" />    
   </th>
  </tr>
 </table>
</body>
</html>