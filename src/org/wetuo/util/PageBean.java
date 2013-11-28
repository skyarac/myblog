package org.wetuo.util;

import java.util.List;
/**
 * <p>分页辅助类<p>
 * @author LH
 * 
 */
public class PageBean <T> {
	/**分页数据**/
	private List<T> list;
	/**总记录数**/
	private int allRow;
	/**总页数**/
	private static int totalPage;
	/**每页显示条数**/
	private int pageSize;
	/**当前页数**/
	private int currentPage;
	@SuppressWarnings("unused")
	/**是否第一页**/
	private boolean isFirstPage;
	@SuppressWarnings("unused")
	/**是否最后一页**/
	private boolean isLastPage;
	@SuppressWarnings("unused")
	/**是否有上一页**/
	private boolean hasPreviousPage;
	@SuppressWarnings("unused")
	/**是否有下一页**/
	private boolean hasNextPage;

	public int getAllRow() {
		return allRow;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	
	public boolean isFirstPage() {// 如是当前页是第1页
		return currentPage==1;
	}
	public boolean isLastPage() {//如果当前页是最后一页
		return currentPage==totalPage;
	}
	public boolean isHasPreviousPage() {//只要当前页不是第1页
		return currentPage!=1;
	}
	public boolean isHasNextPage() {//只要当前页不是最后1页
		return currentPage!=totalPage;
	}
	
	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public void init(){
		this.isFirstPage=isFirstPage();
		this.isLastPage=isLastPage();
		this.hasPreviousPage = isHasPreviousPage();
		this.hasNextPage = isHasNextPage();
	}
	
	public static int countTotalPage(final int pageSize,final int allRow){
		int totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1;
		return totalPage;
	}
	public static int countOffset(final int pageSize,final int currentPage){
		final int offset = pageSize*(currentPage-1);
		return offset;
	}
	public static int countCurrentPage(int page){
		final int curPage = ((page<1||page>totalPage)?1:page);
		return curPage;
	}
	public static void setTotalPage(int totalPage) {
		PageBean.totalPage = totalPage;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}

}
