package edu.cqu.no1.util;

public class PageBean {
	private int currPage = 1;//当前页
	private int totalPage = 1;//总页数
	private int pageCapibility;//每页显示记录条数
	private int totalRows;//	ܹ总行数
	boolean hasNextpage;
	boolean hasPrepage; 
	//查询起始点
	private int beginIndex;
	/** 总记录数*/    
	private int totalCount;   
	public PageBean(int currPage,int totalRows,int pageCapibility )
	{
		this.currPage=currPage;
		this.totalRows = totalRows;
		int total = totalRows / pageCapibility;
		if(totalRows % pageCapibility != 0)//如果数据总行数和每页容量余数不为0，还要多加一页
		{
			total++;
		}
		
		this.totalPage = total;
		
		if(this.totalPage == 0){
			this.totalPage = 1;
		}
		this.pageCapibility = pageCapibility;
		this.hasNextpage = this.isHasNextPage();
		this.hasPrepage = this.isHasPreviousPage();	
		this.beginIndex=(currPage-1)*pageCapibility;
	}
	
	public PageBean(int totalRows,int pageCapibility )
	{
		this.currPage=currPage;
		this.totalRows = totalRows;
		int total = totalRows / pageCapibility;
		if(totalRows % pageCapibility != 0)//如果数据总行数和每页容量余数不为0，还要多加一页
		{
			total++;
		}
		
		this.totalPage = total;

		if(this.totalPage == 0){
			this.totalPage = 1;
		}
		this.pageCapibility = pageCapibility;
		this.hasNextpage = this.isHasNextPage();
		this.hasPrepage = this.isHasPreviousPage();
	}
	public boolean isHasNextPage() {
		return currPage < totalPage;
	}
   //判断当前页是否是第一页
	public boolean isHasPreviousPage() {
		return currPage > 1;
	}
	
	public boolean isHasNextpage() {
		return hasNextpage;
	}
	/**
	 * @param hasNextpage the hasNextpage to set
	 */
	public void setHasNextpage(boolean hasNextpage) {
		this.hasNextpage = hasNextpage;
	}
	/**
	 * @return the hasPrepage
	 */
	public boolean isHasPrepage() {
		return hasPrepage;
	}
	/**
	 * @param hasPrepage the hasPrepage to set
	 */
	public void setHasPrepage(boolean hasPrepage) {
		this.hasPrepage = hasPrepage;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageCapibility() {
		return pageCapibility;
	}

	public void setPageCapibility(int pageCapibility) {
		this.pageCapibility = pageCapibility;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public int getBeginIndex() {
		return beginIndex;
	}

	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	
	


}