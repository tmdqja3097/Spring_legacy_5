package com.iu.s5.util;

public class Pager {
	private Long curPage;
	private Integer perPage;
	
	private long startRow;
	private long lastRow;
	
	private long totalPage;
	private long totalBlock;
	private long curBlock;
	
	private long startNum;
	private long lastNum;
	
	private String kind;
	private String search;
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void makeRow(){
		this.startRow = (this.getCurPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getCurPage()*this.getPerPage();
	}
	
	public void makePage(long totalCount) {
		// 1. totalCount : 전체 글의 갯수
		
		// 2. totalCount로 totalPage 계산
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			this.totalPage++;
		}
		// 3. totalPage로 totalBlock 계산
		long perBlock = 5L; // block당 페이지 수
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock !=0) {
			this.totalBlock++;
		}
		// 4. curPage로 curBlock찾기 
		this.curBlock = this.curPage/perBlock;
		if(curPage%perBlock !=0) {
			this.curBlock++;
		}
		// 5. curBlock startNum, lastNum 계산
		this.startNum = (this.curBlock-1)*perBlock+1;
		this.lastNum = perBlock * this.curBlock;
		if(this.curBlock==this.totalBlock) {
			this.lastNum = this.totalPage;
		}
		
	}
	
	public long getStartRow() {
		return startRow;
	}

	public long getLastRow() {
		return lastRow;
	}

	public long getTotalBlock() {
		return totalBlock;
	}

	public long getCurBlock() {
		return curBlock;
	}

	public long getStartNum() {
		return startNum;
	}

	public long getLastNum() {
		return lastNum;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public Long getCurPage() {
		if(this.curPage == null || this.curPage==0) {
			this.curPage = 1L;
		}
		return curPage;
	}

	public Integer getPerPage() {
		if(this.perPage == null || this.perPage==0) {
			this.perPage=10;
		}
		return perPage;
	}
	public void setPerPage(Integer perPage) {
		this.perPage = perPage;
	}
	public void setCurPage(Long curPage) {
		this.curPage = curPage;
	}

}
