package mvc.board.service;

import mvc.board.dao.JoinDao;
import mvc.board.vo.JoinBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Service어노테이션은 aop의 포인터컷 시작을 알려준다.
public class JoinServiceImp implements JoinService {

	@Autowired
	private JoinDao  joinDao;
	
	//중복아이디
	@Override
	public JoinBean findId(String join_id) {
		return this.joinDao.findId(join_id);
	}

	//회원저장
	@Override
	public void insertJoin(JoinBean j) {
		this.joinDao.insertJ(j);		
	}

	//정보수정
	@Override
	public void editJoin(JoinBean eb) {
		this.joinDao.editJ(eb);		
	}
}




