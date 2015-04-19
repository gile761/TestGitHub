package mvc.board.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.board.service.BoardService;
import mvc.board.vo.BoardBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
//월말평가:@Controller어노테이션을 사용하면 implements Controller
//을 하지 않아도 쉽게 컨트롤 클래스를 만들 수 있다.
public class BoardController {//스프링 컨트롤 클래스를 만듬

    @Autowired
    //월말평가문제:setter()메서드를 통해서 DI 의존관계를 만든다.
    //setter()메서드를 사용하지 않고 오토와이어링 어노테이션을 사용
    //하면 쉽게 DI를 만들수 있다. 스프링에서 DI는 디비 연동 시작을
    //알려준다.
	private BoardService boardService;
	
	/*aop게시판 글쓰기*/
	@RequestMapping(value="/board_write.do",
			method=RequestMethod.GET)
	//get방식으로 접근할때 호출되는 RequestMapping은
	//method=RequestMethod.GET이다.(월말평가)
	public String write(HttpServletRequest request,
			Model wm){
		int page=1;
		if(request.getParameter("page") != null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		wm.addAttribute("page",page);
		return "board/board_write";
	}
	
	/* 저장*/
	@RequestMapping(value="/board_write_ok.do",
			method=RequestMethod.POST)
	//월말평가:POST방식으로 접근할때 호출되는 어노테이션이다.
	public String write_ok(@ModelAttribute BoardBean b)
	throws Exception{
		/*
		 * 월말평가문제:@ModelAttribute 어노테이션을 사용할려면
		 * board_write.jsp 의 피라미터이름과 BoardBean.java의
		 * 변수명이 같아야 한다.
		 */
		this.boardService.insertB(b);//저장메서드를 호출
		return "redirect:/board_list.do";//목록으로 이동
	}
	
	/*목록+검색추가*/
	@RequestMapping(value="/board_list.do")
	public String list(Model listM,HttpServletRequest request,
			@ModelAttribute BoardBean b)
	throws Exception{
		/*
		 * 과제물
		 *  1.한페이지에 10개 목록이 출력되는 페이징(쪽나누기)
		 *  이 되는 목록페이지를 작성해 보세요!
		 */
		int page=1;
		int limit=10;			
		
		String find_name=null;
		String find_field=null;
		
		if(request.getParameter("find_name") != null){
        find_name=request.getParameter("find_name").trim();	
 find_name=new String(find_name.getBytes("ISO-8859-1"),"UTF-8");
 //get방식으로 넘어온 한글을 안깨지게 할려면 String클래스의 
 //getBytes()메서드를 사용해야 한다.
		}
		find_field=request.getParameter("find_field");
		//검색필드를 저장함.board_title,board_cont를 저장
		b.setFind_field(find_field);
		b.setFind_name("%"+find_name+"%");
		//%는 오라클 쿼리문 검색연산자로서 하나이상의임의의 문자와
		//매핑을 한다.?는 오라클 쿼리문 검색연산자로서 하나의 문자
		//와 매핑을 한다.(오라클 월말평가 문제 예상)

		//System.out.println(find_name);
		//이클립스 콘솔모드에 검색어가 출력
		
		if(request.getParameter("page") != null){
			page=Integer.parseInt(request.getParameter("page"));
			//get방식으로 넘어온 쪽번호를 정수형 숫자로 바꿔서 좌측변수에 저장한다.
		}
		
		//검색전 총레코드개수,제목 검색후 레코드 개수,
		//내용 검색후 레코드 개수
		int listcount=this.boardService.getListCount(b);		
        //System.out.println(listcount);
		
		b.setStartrow((page-1)*10+1);
		b.setEndrow(b.getStartrow()+limit-1);
		
		List<BoardBean> blist=
				this.boardService.getBoardList(b);
        //목록 
		
		//총 페이지 수.
		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리.
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		//현재 페이지에 보여줄 마지막 페이지 수.(10, 20, 30 등...)
		int endpage = maxpage;

		if (endpage>startpage+10-1) endpage=startpage+10-1;
		
		listM.addAttribute("blist", blist);
		listM.addAttribute("page", page);
		listM.addAttribute("startpage", startpage);
		listM.addAttribute("endpage", endpage);
		listM.addAttribute("maxpage", maxpage);
		listM.addAttribute("listcount",listcount);	
		listM.addAttribute("find_field",find_field);
		//find_field 키값에 board_title,board_cont저장
		listM.addAttribute("find_name", find_name);
		//find_name 키값에 검색어를 저장
		return "board/board_list";
		//board폴더의 board_list.jsp 뷰페이지로 이동
	}
	
	/*내용보기+수정폼+답변폼+삭제폼*/
	@RequestMapping(value="/board_cont.do")
	public ModelAndView cont(@RequestParam("no") int no,
			@RequestParam("state") String state,
			HttpServletRequest request) throws Exception{
		
		int page=1;
		if(request.getParameter("page") != null){
  page=Integer.parseInt(request.getParameter("page"));
  //get방식으로 넘어온 글번호를 정수형 숫자로 바꿔서 저장
		}
		
		if(state.equals("cont")){//내용보기일때 조회수 증가
	     this.boardService.updateHit(no);
		}
		
		BoardBean b=this.boardService.getCont(no);
		//번호에 해당하는 디비로 부터 레코드를 가져옴.
		String cont=b.getBoard_cont().replace("\n","<br/>");
		//textarea 박스에서 내용 입력시 엔터키 친부분을 다음줄로
		//개행
		
		ModelAndView bm=new ModelAndView();
		bm.addObject("b",b);
		bm.addObject("cont",cont);
		bm.addObject("page", page);
		
		if(state.equals("cont")){//내용보기
			bm.setViewName("board/board_cont");
		}else if(state.equals("reply")){//답변글폼
			bm.setViewName("board/board_reply");
		}else if(state.equals("edit")){//수정폼
			bm.setViewName("board/board_edit");
		}else if(state.equals("del")){//삭제폼
			bm.setViewName("board/board_del");
		}
		return bm;
	}
	
	/*답변저장*/
	@RequestMapping(value="/board_reply_ok.do")
	public String reply_ok(@ModelAttribute BoardBean b,
			HttpServletRequest request)
	throws Exception{
		int page=1;
		if(request.getParameter("page") != null){
  page=Integer.parseInt(request.getParameter("page"));			
		}
		
		this.boardService.reply(b);//답변 저장
		/*
		 * 답변글 정리
		 *  1.board_ref: 원본글과 답변글을 서로 묶어주는 기능을
		 *  하는 글그룹번호이다.즉 원본글 그룹번호와 답변글 그룹
		 *  번호는 같다.그래서 원본글 밑에 답변글이 달린다.
		 *  2.board_step:첫번째 답변글은 1,두번째 답변글은 2이다.
		 *  즉 첫번째 답변글이냐,두번째 답변글이냐를 구분하는
		 *  번호값
		 *  3.board_level:답변글 정렬 순서.
		 */
        return "redirect:/board_list.do?page="+page;
	}
	
	@RequestMapping(value="/board_edit_ok.do")
	public String edit_ok(@ModelAttribute BoardBean eb,
			HttpServletResponse response,
			HttpServletRequest request)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//출력 스트림객체 생성
		int page=1;
		if(request.getParameter("page") != null){
  page=Integer.parseInt(request.getParameter("page"));			
		}
		
  BoardBean db_pwd=this.boardService.getCont(eb.getBoard_no());
  //번호에 해당하는 디비 비번을 가져옴
  if(db_pwd.getBoard_pwd().equals(eb.getBoard_pwd())){
	  this.boardService.editBoard(eb);//게시판 수정
	  return "redirect:/board_cont.do?no="+eb.getBoard_no()+
			  "&page="+page+"&state=cont";
	  //*.do?no=번호값&page=쪽번호&state=cont 3개의 피라미터 값을
	  //get방식으로 넘김
  }else{
	  out.println("<script>");
	  out.println("alert('비번이 다릅니다!')");
	  out.println("history.back()");
	  out.println("</script>");
  }
		return null;
	}
	
	/*삭제*/
	@RequestMapping(value="/board_del_ok.do")
	public String del_ok(@RequestParam("no") int no,
			@RequestParam("del_pwd") String del_pwd,
			HttpServletResponse response,
			HttpServletRequest request)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		int page=1;
		if(request.getParameter("page") != null){
  page=Integer.parseInt(request.getParameter("page"));			
		}
		
		BoardBean db_pwd=this.boardService.getCont(no);
	if(db_pwd.getBoard_pwd().equals(del_pwd)){
		this.boardService.delB(no);
		return "redirect:/board_list.do?page="+page;
	}else{
		out.println("<script>");
		out.println("alert('비번이 다릅니다!')");
		out.println("history.go(-1)");
		out.println("</script>");
	}
		return null;
	}
}
















