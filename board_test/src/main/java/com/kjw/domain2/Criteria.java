package com.kjw.domain2;

/*import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;*/

public class Criteria {

	private int page; //���� ������ ��ȣ
	private int perPageNum; //�� ������ �� ������ ��
	
/*	private PaginationInfo paginationInfo = null;*/
	
	
	public Criteria() {//�⺻��

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
	
	
	//Mybatis SQL Mapper�� ���� �޼���
	
	//�� ������ �� �������� ������ ������!
	public int getPerPageNum() {
		return this.perPageNum;
	}
	
	//�������� ù ��° �����͸� ������!
	public int getPageStart(){
		
		return (this.page - 1) * perPageNum;
	}
	
	
	
	@Override
	public String toString() {
		return "Criteria [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
	
	
}
