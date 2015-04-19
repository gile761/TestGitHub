package mvc.board.service;

import java.util.List;

import mvc.board.vo.BoardBean;

public interface BoardService {

	void insertB(BoardBean b);//저장

	int getListCount(BoardBean b);//총 게시물 수

	List<BoardBean> getBoardList(BoardBean b);//목록

	void updateHit(int no);//조회수 증가

	BoardBean getCont(int no);//답변글폼+수정폼+삭제폼+내용보기

	void reply(BoardBean b);//답변 저장

	void editBoard(BoardBean eb);//수정

	void delB(int no);//삭제
}
