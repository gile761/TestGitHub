package mvc.board.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.board.service.JoinService;
import mvc.board.vo.JoinBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {

	@Autowired
	private JoinService joinService;
	//스프링 setter DI 의존관계를 만들때 setter()메서드를 생략해
	//서 @Autowired 어노테이션으로 만듬.(월말평가 예상문제)
	
	/*로그인폼*/
	@RequestMapping(value="/member_login.do")
	public String login(){
		return "member/member_login";
		//jsp/member/member_login.jsp 뷰페이지가 실행
	}
	
	/*회원가입폼*/
	@RequestMapping(value="/member_join.do")
	public String join(Model m){
		String[] phone={"010","011","016","018","019"};
		
		m.addAttribute("phone",phone);
		//phone키에 폰배열객체를 저장
		
		return "member/member_join";
		//jsp/member폴더의 member_join.jsp 뷰페이지로 이동
	}
	
	/*회원저장*/
	@RequestMapping(value="/member_join_ok.do")
	public String join_ok(@ModelAttribute JoinBean j,
			HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		JoinBean db_id=this.joinService.findId(j.getJoin_id());
		//중복 아이디를 검색
		
		if(db_id != null){
			out.println("<script>");
			out.println("alert('중복아이디가 존재합니다!')");
			out.println("history.go(-1)");
			out.println("</script>");
		}else{
			this.joinService.insertJoin(j);//저장
			return "redirect:/member_login.do";
		}
		return null;
	}
	
	/*로그인 인증*/
	@RequestMapping(value="/member_login_ok.do",
			method=RequestMethod.POST)
	public String login_ok(HttpServletRequest request,
			HttpServletResponse response)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		String login_id=request.getParameter("login_id").trim();
		String login_pwd=request.getParameter("login_pwd").trim();
		
		JoinBean db_id=this.joinService.findId(login_id);
		//디비로 부터 회원정보를 가져옴.
		if(db_id == null){
			out.println("<script>");
			out.println("alert('가입안된 회원입니다')");
			out.println("history.back()");
			out.println("</script>");
		}else{
			if(!db_id.getJoin_pwd().equals(login_pwd)){
				out.println("<script>");
				out.println("alert('비번이 다릅니다!')");
				out.println("history.go(-1)");
				out.println("</script>");
			}else{
				HttpSession session=request.getSession();
				//세션객체를 생성
			session.setAttribute("id",login_id);
			session.setAttribute("name",db_id.getJoin_name());
			return "redirect:/index.do";
			}
		}
		return null;
	}
	
	/*메인화면*/
	@RequestMapping(value="/index.do")
	public String index(HttpServletResponse response,
			HttpServletRequest request,HttpSession session)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session=request.getSession();
		
	    String id=(String)session.getAttribute("id");
	    //세션 아이디 값을 가져옴.
	    if(id==null){
	    	out.println("<script>");
	    	out.println("alert('다시 로그인 하세요!')");
	    	out.println("location='member_login.do'");
	    	out.println("</script>");
	    }else{
	    	return "index";
	    }
	    return null;
	}
	
	/*로그아웃*/
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session=request.getSession();//세션객체를 구함.
		
		session.invalidate();//세션을 만료
		
		out.println("<script>");
		out.println("alert('로그아웃 되었습니다!')");
		out.println("location='member_login.do'");
		out.println("</script>");
		
		return null;
	}
	
	/*정보수정*/
	@RequestMapping(value="/member_edit.do")
	public String edit(HttpServletResponse response,
			HttpServletRequest request,
			HttpSession session,Model em)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session=request.getSession();
		
		String id=(String)session.getAttribute("id");
		
		if(id==null){
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='member_login.do'");
			out.println("</script>");
		}else{
			String[] phone={"010","011","016","018","019"};
			em.addAttribute("phone",phone);
			JoinBean eb=this.joinService.findId(id);
			em.addAttribute("eb",eb);
			return "member/member_edit";
		}
		return null;
	}
	
	/*정보수정*/
	@RequestMapping(value="/member_edit_ok.do")
	public String edit_ok(HttpServletRequest request,
			HttpServletResponse response,
			HttpSession session,@ModelAttribute JoinBean eb)
	throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		session=request.getSession();
		
		String id=(String)session.getAttribute("id");
		if(id==null){
			out.println("<script>");
			out.println("alert('다시 로그인 하세요!')");
			out.println("location='member_login.do'");
			out.println("</script>");
		}else{
			eb.setJoin_id(id);//아이디를 저장
			this.joinService.editJoin(eb);//수정메서드 호출
			out.println("<script>");
			out.println("alert('수정했습니다!')");
			out.println("location='member_edit.do'");
			out.println("</script>");
		}
		return null;
	}
}













