package mvc.board.dao;

import mvc.board.vo.JoinBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JoinDaoImp implements JoinDao {

	@Autowired
	private SqlMapClientTemplate template;
	//template이 ibatis쿼리문을 실행할수 있다.
	
	//중복아이디 검색
	@Override
	public JoinBean findId(String join_id) {
		return (JoinBean)template.queryForObject("find_id",
				join_id);
		//find_id는 select 아이디 이름
	}

	/*회원저장*/
	@Override
	public void insertJ(JoinBean j) {
		template.insert("join_in",j);		
	}

	/*정보수정*/
	@Override
	public void editJ(JoinBean eb) {
		template.update("join_edit",eb);		
	}
}



