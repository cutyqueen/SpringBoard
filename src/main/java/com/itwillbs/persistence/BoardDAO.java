package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

public interface BoardDAO {
	
	/* 게시글 작성 */
	public void insertBoard(BoardVO vo) throws Exception;
	
	/* 모든 글 조회 */
	public List<BoardVO> getBoardListAll() throws Exception;
	
	/* 글 본문보기 */
	public BoardVO getBoard(int bno) throws Exception;
	
	/*수정하기*/
	public int updateBoard(BoardVO vo) throws Exception;

	/*조회수 1증가*/
	public void updateViewCnt(int bno) throws Exception;
	
	/*글 삭제*/
	public void deleteBoard(int bno) throws Exception;

	/*페이징 처리*/
	public List<BoardVO> getBoardListPage(int page) throws Exception;
	
	/*페이징 처리-매개변수변경*/
	public List<BoardVO> getBoardListPage(Criteria cri) throws Exception;
	
	/*전체글 개수 조회*/
	public int getBoardCount() throws Exception;
	
	
	
	
	
}
