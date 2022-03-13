package com.org.kr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.org.kr.utils.PagingGenerator;


public class AbstractDAO {
	protected Log log = LogFactory.getLog(AbstractDAO.class);
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	protected void printQueryId(String queryId) {
		if(log.isDebugEnabled()){
			log.debug("\t QueryId  \t:  " + queryId);
		}
	}
	
	public Object insert(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.insert(queryId, params);
	}
	
	public Object update(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.update(queryId, params);
	}
	
	public Object delete(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.delete(queryId, params);
	}
	
	public Object selectOne(String queryId){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId);
	}
	
	public Object selectOne(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.selectOne(queryId, params);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId){
		printQueryId(queryId);
		return sqlSession.selectList(queryId);
	}
	
	@SuppressWarnings("rawtypes")
	public List selectList(String queryId, Object params){
		printQueryId(queryId);
		return sqlSession.selectList(queryId,params);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map selectPagingList(String queryId, Object params){
		printQueryId(queryId);
		
		Map<String,Object> map = (Map<String,Object>)params;
		
		if(map.containsKey("currentPageNo") == false || StringUtils.isEmpty(map.get("currentPageNo")) == true)
			map.put("currentPageNo","1");

		int setPage = 0;
		if(map.containsKey("setPage") == false || StringUtils.isEmpty(map.get("setPage")) == true){
			setPage = 10;
		}else{
			setPage = Integer.parseInt(map.get("setPage").toString());
		}
		
		int start = (Integer.parseInt(map.get("currentPageNo").toString()) - 1) * setPage;
		map.put("START",start);
		map.put("END", setPage);

		int totalCnt = Integer.parseInt(map.get("TOTAL_CNT").toString());
		int currentPageNo = Integer.parseInt(map.get("currentPageNo").toString());
		
		PagingGenerator paging = new PagingGenerator(10, setPage, totalCnt, currentPageNo);
		String pageGenerator= paging.generateEshare("fn_search");
		
		params = map;

		Map<String,Object> returnMap = new HashMap<String,Object>();
		List<Map<String,Object>> list = sqlSession.selectList(queryId,params);
		
		returnMap.put("result", list);
		returnMap.put("setPage", setPage);
		returnMap.put("totalCnt", totalCnt);
		returnMap.put("currentPageNo", currentPageNo);
		returnMap.put("pageGenerator", pageGenerator);
		
		return returnMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map selectPagingList2(String queryId, Object params){
		printQueryId(queryId);
		
		Map<String,Object> map = (Map<String,Object>)params;
		
		if(map.containsKey("currentPageNo") == false || StringUtils.isEmpty(map.get("currentPageNo")) == true)
			map.put("currentPageNo","1");
		
		int setPage = 0;
		if(map.containsKey("setPage") == false || StringUtils.isEmpty(map.get("setPage")) == true){
			setPage = 10;
		}else{
			setPage = Integer.parseInt(map.get("setPage").toString());
		}
		
		int start = (Integer.parseInt(map.get("currentPageNo").toString()) - 1) * setPage;
		map.put("START",start);
		map.put("END", setPage);
		
		int totalCnt = Integer.parseInt(map.get("TOTAL_CNT").toString());
		int currentPageNo = Integer.parseInt(map.get("currentPageNo").toString());
		
		PagingGenerator paging = new PagingGenerator(10, setPage, totalCnt, currentPageNo);
		String pageGenerator= paging.generateEshare("fn_search2");
		
		params = map;
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		List<Map<String,Object>> list = sqlSession.selectList(queryId,params);
		
		returnMap.put("result", list);
		returnMap.put("setPage", setPage);
		returnMap.put("totalCnt", totalCnt);
		returnMap.put("currentPageNo", currentPageNo);
		returnMap.put("pageGenerator", pageGenerator);
		
		return returnMap;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map selectPagingList3(String queryId, Object params){
		printQueryId(queryId);
		
		Map<String,Object> map = (Map<String,Object>)params;
		
		if(map.containsKey("currentPageNo") == false || StringUtils.isEmpty(map.get("currentPageNo")) == true)
			map.put("currentPageNo","1");
		
		int setPage = 0;
		if(map.containsKey("setPage") == false || StringUtils.isEmpty(map.get("setPage")) == true){
			setPage = 10;
		}else{
			setPage = Integer.parseInt(map.get("setPage").toString());
		}
		
		int start = (Integer.parseInt(map.get("currentPageNo").toString()) - 1) * setPage;
		map.put("START",start);
		map.put("END", setPage);
		
		int totalCnt = Integer.parseInt(map.get("TOTAL_CNT").toString());
		int currentPageNo = Integer.parseInt(map.get("currentPageNo").toString());
		
		PagingGenerator paging = new PagingGenerator(10, setPage, totalCnt, currentPageNo);
		String pageGenerator= paging.generateEshare("fn_search3");
		
		params = map;
		
		Map<String,Object> returnMap = new HashMap<String,Object>();
		List<Map<String,Object>> list = sqlSession.selectList(queryId,params);
		
		returnMap.put("result", list);
		returnMap.put("setPage", setPage);
		returnMap.put("totalCnt", totalCnt);
		returnMap.put("currentPageNo", currentPageNo);
		returnMap.put("pageGenerator", pageGenerator);
		
		return returnMap;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List selectAjaxPagingList(String queryId, Object params){
		printQueryId(queryId);
		
		Map<String,Object> map = (Map<String,Object>)params;
		
		if(map.containsKey("currentPageNo") == false || StringUtils.isEmpty(map.get("currentPageNo")) == true)
			map.put("currentPageNo","1");
		
		int setPage = 0;
		if(map.containsKey("setPage") == false || StringUtils.isEmpty(map.get("setPage")) == true){
			setPage = 10;
		}else{
			setPage = Integer.parseInt(map.get("setPage").toString());
		}
		
		int start = (Integer.parseInt(map.get("currentPageNo").toString()) - 1) * setPage;
		
		map.put("START", start);
		map.put("END", setPage);
		params = map;

		List<Map<String,Object>> list = sqlSession.selectList(queryId,params);
		return list;
	}
}
