<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 삭제</title>
<script src="./js/jquery.js"></script>
<script>
  function del_check(){
	  if($.trim($("#del_pwd").val())==""){
		  alert("비번을 입력하세요!");
		  $("#del_pwd").val("''").focus();
		  return false;
	  }
  }
</script>
</head>
<body>
 <form method="post" action="board_del_ok.do"
 onsubmit="return del_check();">
 <input type="hidden" name="no" value="${b.board_no}" />
 <input type="hidden" name="page" value="${page}" />
 <table align="center" border="1">
  <tr>
   <th colspan="2">게시판 삭제</th>
  </tr>
  <tr>
   <th>비밀번호</th>
   <td>
   <input type="password" name="del_pwd" id="del_pwd"
   size="14" />
   </td>
  </tr>
  <tr>
   <th colspan="2">
   <input type="submit" value="삭제" />
   <input type="reset" value="취소"
   onclick="$('#del_pwd').focus();" />
   </th>
  </tr>
 </table>
 </form>
</body>
</html>
<%--
  과제물
   1.BoardController.java에서 board_del_ok.do 부분 삭제 컨트롤
   @RequestMapping을 작성하세요.메서드 이름은 del_ok()로 하시면
   됩니다.
   2.비번이 같으면 삭제되게 하고,다르면 비번이 다릅니다 라고 
   alert()경고창을 띄우세요!
   3.삭제 완료후 board_list.do?page=쪽번호 로 목록으로 이동하게 
   하세요... 풀이는 2시 35분에 합니다.
--%>