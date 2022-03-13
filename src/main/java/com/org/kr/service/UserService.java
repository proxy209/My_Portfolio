package com.org.kr.service;

import java.util.List;
import java.util.Map;

public interface UserService {
	public int loginChk(Map<String, Object> map) throws Exception;
	
	public int boardUpload(Map<String, Object> map) throws Exception;
	
	public List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception;
	
	public Map<String, Object> boardDetail(Map<String, Object> map) throws Exception;
}
