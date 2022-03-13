/**
 * @PagingGenerator.java
 *
 * @version 1.0  2019. 03. 08 
 * @author edge
 * 
 */
package com.org.kr.utils;


public class PagingGenerator {
	
	protected String queryFunctionName = "limit";
	protected int currentPage = 1;
	protected int totalCount = 1;
	protected int viewCount = 10;
	protected int pageCount = 10;
	private int totalPage;
	private int startPage;

	
	/**
	 * @param request
	 * @param pageCount 표시할 페이지의 수
	 * @param viewCount 한페이지 당 컨텐츠 갯수
	 * @param totalCnt 전체 컨텐츠 수
	 * @param currentPage 현재 페이지
	 */
	public PagingGenerator(int pageCount, int viewCount, int totalCnt, int currentPage){
		this.pageCount = pageCount;
		this.viewCount = viewCount;
		this.totalCount = totalCnt;
		this.currentPage = currentPage;
	}

	/**
	 * default call function 'goPage'
	 * @return generate("goPage")
	 */
	public String generate() {
		return generate("goPage");
	}
	
	public String generate(String functionName) {
		setPageValues();

		StringBuilder pagingHtml = new StringBuilder();
		
	 	// 첫번째/이전 버튼 생성
		if (currentPage / (pageCount + 1) > 0) {  
			pagingHtml.append("<a class='pre_page' href='javascript:"+functionName+"(" + (currentPage - 1) + ");'>이전</a>");
		} else {
			if( currentPage > 1) {
				pagingHtml.append("<a class='pre_page' href='javascript:"+functionName+"(" + (currentPage - 1) + ");'>이전</a>");
			} else {
				pagingHtml.append("<a href='#' class='pre_page'>이전</a>");
			}
		}

		// 페이지 리스트 버튼 생성
		for (int i = startPage; i < startPage + pageCount; i++) {
			if (i > totalPage)
				break;
			if (currentPage == i) {
				pagingHtml.append("<strong><span>" + i + "</span></strong>");
			} else {
				pagingHtml.append("<a href='javascript:"+functionName+"(" + i + ");'><span>" + i + "</span></a>");
			}
		}

		// 다음/마지막 버튼 생성
		if (startPage + pageCount <= totalPage) {
			pagingHtml.append("<a class='next_page' href='javascript:"+functionName+"(" + (currentPage + 1) + ");'>다음</a>");
		} else {
			if( currentPage < totalPage) {
				pagingHtml.append("<a class='next_page' href='javascript:"+functionName+"(" + (currentPage + 1) + ");'>다음</a>");
			} else {
				pagingHtml.append("<a href='#' class='next_page'>다음</a>");
			}
			
		}

		return pagingHtml.toString();
	}

	public String generateNew(String functionName) {
		setPageValues();

		StringBuilder pagingHtml = new StringBuilder();
		
	 	// 첫번째/이전 버튼 생성
		pagingHtml.append("<p class='pager_arrow prev'>");
		if (currentPage / (pageCount + 1) > 0) {  
			pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage - 1) + ");'>이전</a>");
		} else {
			if( currentPage > 1) {
				pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage - 1) + ");'>이전</a>");
			} else {
				pagingHtml.append("<a href='javascript:void(0)'>이전</a>");
			}
		}
		pagingHtml.append("</p>");

		// 페이지 리스트 버튼 생성
		pagingHtml.append("<ul>");
		for (int i = startPage; i < startPage + pageCount; i++) {
			if (i > totalPage)
				break;
			if (currentPage == i) {
				pagingHtml.append("<li><a class='on' href='javascript:void(0);'>" + i + "</a></li>");
			} else {
				pagingHtml.append("<li><a href='javascript:"+functionName+"(" + i + ");'>" + i + "</a></li>");
			}
		}
		pagingHtml.append("</ul>");

		// 다음/마지막 버튼 생성
		pagingHtml.append("<p class='pager_arrow next'>");
		if (startPage + pageCount <= totalPage) {
			pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage + 1) + ");'>다음</a>");
		} else {
			if( currentPage < totalPage) {
				pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage + 1) + ");'>다음</a>");
			} else {
				pagingHtml.append("<a href='javascript:void(0)' class='next_page'>다음</a>");
			}
		}
		pagingHtml.append("</p>");

		return pagingHtml.toString();
	}

	public String generateBootStrapEla(String functionName) {
		setPageValues();

		StringBuilder pagingHtml = new StringBuilder();
		
		if(totalPage == 0 || totalPage == 1) {
			return "";
		}
		
		pagingHtml.append("<div class='dataTables_paginate paging_simple_numbers' style='width:100%; text-align:center; '>");
		// 첫번째/이전 버튼 생성
		if (currentPage / (pageCount + 1) > 0) {  
			pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage - 1) + ");' class='paginate_button previous'>이전</a>");
		} else {
			if( currentPage > 1) {
				pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage - 1) + ");' class='paginate_button previous'>이전</a>");
			} else {
				pagingHtml.append("<a href='javascript:void(0)' class='paginate_button previous disabled'>이전</a>");
			}
		}

		// 페이지 리스트 버튼 생성
		pagingHtml.append("<span>");
		for (int i = startPage; i < startPage + pageCount; i++) {
			if (i > totalPage)
				break;
			if (currentPage == i) {
				pagingHtml.append("<a href='javascript:void(0);' class='paginate_button current'>" + i + "</a>");
			} else {
				pagingHtml.append("<a href='javascript:"+functionName+"(" + i + ");' class='paginate_button'>" + i + "</a>");
			}
		}
		pagingHtml.append("</span>");

		// 다음/마지막 버튼 생성
		if (startPage + pageCount <= totalPage) {
			pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage + 1) + ");' class='paginate_button next'>다음</a>");
		} else {
			if( currentPage < totalPage) {
				pagingHtml.append("<a href='javascript:"+functionName+"(" + (currentPage + 1) + ");' class='paginate_button next'>다음</a>");
			} else {
				pagingHtml.append("<a href='javascript:void(0)' class='paginate_button next disabled'>다음</a>");
			}
		}
		pagingHtml.append("</div>");

		return pagingHtml.toString();
	}

	public String generateEshare(String functionName) {
		setPageValues();

		StringBuilder pagingHtml = new StringBuilder();
		
		if(totalPage == 0 || totalPage == 1) {
			return "";
		}
		
		pagingHtml.append("<div class='tbl_pagination'>");
		pagingHtml.append("<p class='first'><a href='javascript:"+functionName+"(" + (1) + ");'>처음으로</a></p>");
		// 첫번째/이전 버튼 생성
		if (currentPage / (pageCount + 1) > 0) {  
			pagingHtml.append("<p class='prev'><a href='javascript:"+functionName+"(" + (currentPage - 1) + ");'>앞으로</a></p>");
		} else {
			if( currentPage > 1) {
				pagingHtml.append("<p class='prev'><a href='javascript:"+functionName+"(" + (currentPage - 1) + ");'>앞으로</a></p>");
			} else {
				pagingHtml.append("<p class='prev'><a href='javascript:void(0)'>앞으로</a></p>");
			}
		}

		// 페이지 리스트 버튼 생성
		pagingHtml.append("<ol>");
		for (int i = startPage; i < startPage + pageCount; i++) {
			if (i > totalPage)
				break;
			if (currentPage == i) {
				pagingHtml.append("<li><a class='on' href='javascript:void(0)'>"+ i +"</a></li>");
			} else {
				pagingHtml.append("<li><a class='' href='javascript:"+ functionName+"("+i+");'>"+ i +"</a></li>");
			}
		}
		pagingHtml.append("</ol>");

		// 다음/마지막 버튼 생성
		if (startPage + pageCount <= totalPage) {
			pagingHtml.append("<p class='next'><a href='javascript:"+functionName+"(" + (currentPage + 1) + ");'>뒤로</a></p>");
		} else {
			if( currentPage < totalPage) {
				pagingHtml.append("<p class='next'><a href='javascript:"+functionName+"(" + (currentPage + 1) + ");'>뒤로</a></p>");
			} else {
				pagingHtml.append("<p class='next'><a href='javascript:void(0);'>뒤로</a></p>");
			}
		}
		pagingHtml.append("<p class='last'><a href='javascript:"+functionName+"(" + (totalPage) + ");'>끝으로</a></p>");
		pagingHtml.append("</div>");

		return pagingHtml.toString();
	}
	
	public int getStartIndex() {
		
		// a between 1 to 20 (1부터 20까지)
		if (queryFunctionName.equals("between")){
			return viewCount * (currentPage - 1) + 1;
		// limit 0, 20 (0부터 20건)
		} else if (queryFunctionName.equals("limit")){
			return viewCount * (currentPage - 1);
		} else {
			return viewCount * (currentPage - 1) + 1;
		}
	}

	public int getEndIndex() {
		return viewCount * currentPage;
	}

	protected void setPageValues() { 
		totalPage = (totalCount / viewCount) + (totalCount % viewCount > 0 ? 1 : 0);
		startPage = ((currentPage - 1) / pageCount) * pageCount + 1;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
}
