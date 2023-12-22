package com.itwillbs.service;

import java.util.List;import org.springframework.jdbc.core.CallableStatementCreator;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardService {
	
	/* 게시판 글 작성 */
	public void boardWrite(BoardVO vo) throws Exception;
	
	/* 게시판 리스트*/
	public List<BoardVO> boardListAll() throws Exception;
	
	/* 글 본문보기 */
	public BoardVO getBoard(int bno) throws Exception;
	
	/*글 수정*/
	public int boardModify(BoardVO vo) throws Exception;
	
	/*조회수 1증가*/
	public void incrementViewCnt(int bno) throws Exception;
	
	/*글 삭제*/
	public void boardRemove(int bno) throws Exception;

	/*페이징 처리*/
	public List<BoardVO> boardListPage(Criteria cri) throws Exception;

	/*전체글 개수 조회*/
	public int totalBoardCount() throws Exception;
	

}
