package mvc.board.dao;

import java.util.List;

import mvc.board.vo.BoardBean;

public interface BoardDao {

	void insertB(BoardBean b);//저장

	int getCount(BoardBean b);//총 게시물 수

	List<BoardBean> getList(BoardBean b);//목록

	void editHit(int no);//조회수 증가

	BoardBean getBoardCont(int no);//수정폼+삭제폼+답변글폼+내용

	void replyBoard(BoardBean b);//답변 저장

	void editB(BoardBean eb);//수정

	void delBoard(int no);//삭제
}







