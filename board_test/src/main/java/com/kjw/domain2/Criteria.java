package com.kjw.domain2;

/*import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;*/

public class Criteria {

	private int page; //현재 페이지 번호
	private int perPageNum; //한 페이지 당 데이터 수
	
/*	private PaginationInfo paginationInfo = null;*/
	
	
	public Criteria() {//기본값

		this.page = 1; 
		this.perPageNum = 10;
	}
	
	public void setPage(int page) {
		
		if(page <= 0){
			this.page = 1;
			return;
		}
		
		this.page = page;
	}
	
	public int getPage() {
		return page;
	}
	
	
	
	public void setPerPageNum(int perPageNum) {
		
		if(perPageNum <= 0 || perPageNum > 100){
			this.perPageNum = 10;
			return;
		}
		
		this.perPageNum = perPageNum;
	}
	
	
	//Mybatis SQL Mapper를 위한 메서드
	
	//한 페이지 당 데이터의 개수를 가져옴!
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	//페이지의 첫 번째 데이터를 가져옴!
	public int getPageStart(){
		
		return (this.page - 1) * perPageNum;
	}
	
	
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}
