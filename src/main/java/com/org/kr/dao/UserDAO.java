package com.org.kr.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.org.kr.AbstractDAO;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{
	
	public int login(Map<String, Object> map) throws Exception {
		return (int) selectOne("member.selectUser", map);
	}
	
	public int boardUpload(Map<String, Object> map) throws Exception {
		return (int) insert("member.boardUpload", map);
	}
	
	public int fileUpload(Map<String, Object> listMap) throws Exception {
		return (int) insert("member.fileUpload", listMap);
	}
	
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>>  boardList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("member.boardList", map);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Object> boardDetail(Map<String, Object> map) throws Exception {
		return (Map<String, Object>) selectOne("member.boardDetail", map);
	}
}
