package com.kjw.domain2;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10; //한 화면에 나오는 페이지 수
	
	private Criteria cri;


	public void setCri(Criteria cri) {
		this.cri = cri;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}

	
	public void calcData(){
		
		endPage = (int)(Math.ceil(cri.getPage()/(double)displayPageNum)*displayPageNum); //끝 페이지
		
		startPage = (endPage - displayPageNum) + 1; //시작 페이지
		
		
		int tempEndPage = (int)(Math.ceil(totalCount/(double)cri.getPerPageNum())); //전체 데이터 수 고려해서 끝 페이지 한번 더 계산
		
		if(endPage > tempEndPage){
			endPage = tempEndPage;
		}
		
		
		prev = startPage == 1 ? false:true; //이전 페이지 이동
		
		next = endPage * cri.getPerPageNum() >= totalCount ? false:true; //다음 페이지 이동
	}

	

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

	
	public String makeQuery(int page){
		
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.build();
		
		return uriComponents.toUriString();
	}
	
	
	public String makeSearch(int page){
		
		UriComponents uriComponents = 
				UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("perPageNum", cri.getPerPageNum())
				.queryParam("searchType", ((SearchCriteria)cri).getSearchType())
				.queryParam("keyword", ((SearchCriteria)cri).getKeyword())
				.build();
		
		return uriComponents.toUriString();
	}
	

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage + ", prev="
				+ prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", cri=" + cri + "]";
	}
	
	
	
}
