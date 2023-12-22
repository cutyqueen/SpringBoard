package com.itwillbs.domain;
/**
 * 페이징 처리에 필요한 정보를 저장하는 객체
 *  => 총개수, 시작페이지번호, 끝페이지번호, 이전페이지링크, 다음페이지링크, 블럭의 크기  
 *  	+Cri(페이지번호, 페이지사이즈)  
 * 	
 *  총 개수         : totalCount
 * 	끝페이지번호    : endPage = ceil(페이지번호/페이지사이즈) * 블럭의 크기
 * 							  *ceil:올림 - 12페이지 : ceil(12/10)*10= 20 페이지
 *  시작페이지번호  :  startPage = (endPage - 블럭의 크기) +1;
 *  							*7페이지 : 10-10+1= 1 페이지
 *  이전페이지링크   : prev(boolean) = startPage !=1
 *  다음페이지링크   : next(boolean) = endPage * pageSize < totalCount
 *  							
 */

public class PageVO {
	
	private int totalCount; // 총개수
	private int startPage; // 페이지 블럭 시작번호
	private int endPage; // 페이지 블럭 끝번호
	
	private boolean prev; // 이전링크
	private boolean next; // 다음링크
	
	private int displayPageNum=10; // 페이지 블럭의 크기
	
	private Criteria cri; //page, pageSize
	
	// 페이지번호, 페이지 사이즈 지정
	public void setCri(Criteria cri) {
		this.cri = cri;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		// 페이징 처리에 필요한 정보를 모두 계산
		calcData();
	}

	private void calcData() {
		// 페이징처리 정보를 모두 계산
		
		// 끝페이지
		endPage = (int)(Math.ceil(cri.getPage() / (double)displayPageNum))*displayPageNum;
		//시작페이지번호
		startPage = (endPage-displayPageNum)+1;
		
		//끝페이지 번호체크(글이 없는 경우)
		//int tmpEndPage = totalCount / cri.getPageSize() + (totalCount%cri.getPageSize()==0? 0:1);
		int tmpEndPage = (int)(Math.ceil(((double)totalCount / cri.getPageSize())));
		
		if(endPage>tmpEndPage) {
			endPage = tmpEndPage;
		}
		
		// 이전링크
//		prev = startPage != 1;
		prev = startPage == 1 ? false : true;
		// 다음링크
		next = endPage * cri.getPageSize() < totalCount;
//		next = endPage * cri.getPageSize() >= totalCount ? false : true;
		
		// 페이징처리 정보를 계산완
	} // calcDate()
	
	/**************************************************/
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	public int getTotalCount() {
		return totalCount;
	}
	
	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageVO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	
}
