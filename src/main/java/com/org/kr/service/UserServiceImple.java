package com.org.kr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.kr.dao.UserDAO;
import com.org.kr.utils.SHA256;


@Service("user")
public class UserServiceImple implements UserService{

	private UserDAO userDAO;
	
	private SHA256 sha256;
	
	@Autowired
	public UserServiceImple(UserDAO userDAO, SHA256 sha256){
		this.userDAO = userDAO;
		this.sha256 = sha256;
	}
	
	@Override
	public int loginChk(Map<String, Object> map) throws Exception {
		String email = (String) map.get("email");
		String passwd = (String) map.get("passwd");
		
		Map<String, Object> map2 = new HashMap<>();
		
		map2.put("email", email);
		map2.put("passwd", sha256.shaEncrypt(passwd));
		
		return userDAO.login(map2);
	}
	
	@Override
	public int boardUpload(Map<String, Object> map) throws Exception {
		
		return userDAO.boardUpload(map);
	}
	
	@Override
	public List<Map<String, Object>> boardList(Map<String, Object> map) throws Exception {
		
		return userDAO.boardList(map);
	}
	
	@Override
	public Map<String, Object> boardDetail(Map<String, Object> map) throws Exception {
		
		return userDAO.boardDetail(map);
	}

}
