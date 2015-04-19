package mvc.board.service;

import java.util.List;

import mvc.board.dao.BoardDao;
import mvc.board.vo.BoardBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@Service 어노테이션은 데이터베이스 연동을 시작하는 
//클래스에 적용할때 사용함.
public class BoardServiceImp implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	/*목록*/
	@Override
	public void insertB(BoardBean b) {
	  this.boardDao.insertB(b);	
	}
    
	/*총 게시물 수*/
	@Override
	public int getListCount(BoardBean b) {
		int count=0;
		count=this.boardDao.getCount(b);
		return count;
	}

	/*목록*/
	@Override
	public List<BoardBean> getBoardList(BoardBean b) {
		return this.boardDao.getList(b);
	}

	/*조회수 증가*/
	@Override
	public void updateHit(int no) {
		this.boardDao.editHit(no);	
	}

	/*내용보기+수정폼+삭제폼+답변글폼*/
	@Override
	public BoardBean getCont(int no) {
		return this.boardDao.getBoardCont(no);
	}

	//답변 저장
	@Override
	public void reply(BoardBean b) {
		this.boardDao.replyBoard(b);		
	}

	//수정
	@Override
	public void editBoard(BoardBean eb) {
		this.boardDao.editB(eb);
	}

	//삭제
	@Override
	public void delB(int no) {
		this.boardDao.delBoard(no);		
	}	
}





