package mvc.board.dao;

import mvc.board.vo.JoinBean;

public interface JoinDao {

	JoinBean findId(String join_id);//중복아이디

	void insertJ(JoinBean j);//회원저장

	void editJ(JoinBean eb);//정보수정
}
