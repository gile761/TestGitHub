package mvc.board.dao;

import java.util.List;

import mvc.board.vo.BoardBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
/* 이 어노테이션은 BoardDaoImp 클래스를
 <bean id="boardDao" class="mvc.board.dao.BoardDaoImp">
  <property name="sqlMapClient" ref="sqlMapClient" />
 </bean>
 xml에 하지 않고 쉽게 어노테이션으로 ibatis 를 실행하게 해줌. 

XML로 빈을 설정하지 않으려면 메인 설정 xml에 
<context:component-scan base-package="mvc.board.*" />
가 필요하다. 
 */
public class BoardDaoImp implements BoardDao {

	@Autowired
	private SqlMapClientTemplate template;
	//자동 와이어링을 통해서 ibatis 실행 객체를 생성
	/*
	 * ORM ibatis 쿼리문 실행 메서드 정리(월말평가)
	 * 1.한개이상 레코드를 검색해서 컬렉션 List로 반환해주는
	 * 메서드:queryForList()
	 * 2.단 한개의 레코드를 검색해주는 메서드:queryForObject()
	 * 3.레코드를 수정해주는 메서드:update()
	 * 4.레코드를 삭제해주는 메서드:delete()
	 * 5.레코드를 저장해주는 메서드:insert()
	 */

	/*저장*/
	@Override
	public void insertB(BoardBean b) {
		template.insert("b_in",b);
		//b_in 은 insert 아이디 이름
	}

	/*총 게시물수*/
	@Override
	public int getCount(BoardBean b) {
	    int count=0;
	    count=(int)template.queryForObject("b_count",b);
		return count;
	}

	/*목록*/
	@SuppressWarnings("unchecked")
	@Override
	public List<BoardBean> getList(BoardBean b) {
		return template.queryForList("b_list",b);
	}

	/*조회수 증가*/
	@Override
	public void editHit(int no) {
	 template.update("b_hit",no);	
	}

	//내용
	@Override
	public BoardBean getBoardCont(int no) {
    return (BoardBean)template.queryForObject("b_cont",no);
	}

	//답변 저장
	@Override
	public void replyBoard(BoardBean b) {
		template.update("b_level",b);//답변 레벨 증가	
		template.insert("b_reply",b);//답변 저장
	}

	//수정
	@Override
	public void editB(BoardBean eb) {
	   template.update("b_edit",eb);		
	}

	//삭제
	@Override
	public void delBoard(int no) {
	   template.delete("b_del",no);		
	}
}







