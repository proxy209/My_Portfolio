package com.org.kr.utils;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.org.kr.dao.UserDAO;

@Component("fileUtils")
public class FileUtils {
	
	protected Log log = LogFactory.getLog(FileUtils.class);
	
	private final UserDAO userDAO;
	
	public FileUtils(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
		
	/**
	private static final String filePath = "C:\\dev\\file\\";
	**/
	
	public List<Map<String,Object>> parseInsertFileInfo(Map<String,Object> map, MultipartHttpServletRequest request) throws Exception{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		Iterator<String> iterator = request.getFileNames();
		Map<String, Object> listMap = null;
		
		MultipartFile multipartFile = null;
		String fileSaveName = null;
		String fileOriginName = null;
		String filePath = request.getSession().getServletContext().getRealPath("resources/uploads/");
		
		File file = new File(filePath);
		if(file.exists() == false) {
			file.mkdir();
		}
		
		while(iterator.hasNext()){
			multipartFile = request.getFile(iterator.next());
			listMap = new HashMap<String,Object>();
			
			if(multipartFile.isEmpty() == false){
				fileOriginName = multipartFile.getOriginalFilename();
				String fileType = fileOriginName.substring(fileOriginName.lastIndexOf("."));
				fileSaveName = "FILENEW_"+getTimeStamp()+fileType;
				
				long fileSize = multipartFile.getSize();
				
				file = new File(filePath +"/"+ fileSaveName);
				multipartFile.transferTo(file);
				
				listMap.put("fileSaveName", fileSaveName);
				listMap.put("fileOriginName", fileOriginName);
				listMap.put("filePath", filePath);
				listMap.put("boardNo", map.get("BOARD_NO"));
				
				userDAO.fileUpload(listMap);
			}
			 
			list.add(listMap);
		}
		
		return list;
	}
	
	private String getTimeStamp() {
        String rtnStr = null;
        // 문자열로 변환하기 위한 패턴 설정(년도-월-일 시:분:초:초(자정이후 초))
        String pattern = "yyyyMMddhhmmssSSS";
        try {
            SimpleDateFormat sdfCurrent = new SimpleDateFormat(pattern, Locale.KOREA);
            Timestamp ts = new Timestamp(System.currentTimeMillis());

            rtnStr = sdfCurrent.format(ts.getTime());
        } catch (Exception e) {
            log.debug("getTimeStamp: " + e.getMessage());
        }

        return rtnStr;
    }
}