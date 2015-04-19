package mvc.board.service;

import mvc.board.vo.JoinBean;

public interface JoinService {

	JoinBean findId(String join_id);//중복아이디
	//추상메서드 앞에 public abstract이 생략됨.

	void insertJoin(JoinBean j);//회원저장

	void editJoin(JoinBean eb);//정보수정
}
