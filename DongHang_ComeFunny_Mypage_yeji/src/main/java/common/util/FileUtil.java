package common.util;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import common.exception.FileException;

public class FileUtil {
	
	public List<Map<String, String>> fileUpload(
			List<MultipartFile> files, String root) throws FileException {
	
		int idx = 0;
		List<Map<String, String>> filedate = new ArrayList<Map<String, String>>();
		
		for(MultipartFile mf: files) {
           
			//빈 파일을 생성할 경로
           String savePath = root + "resources/upload";
           
           //tb_file에 넣을 데이터 추출
           //originFileName, renameFileName, SavePath
           String originFileName = mf.getOriginalFilename();
           SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
           
           //저장할 파일 이름 생성
           String renameFileName = sdf.format(
        		   new Date(System.currentTimeMillis())) + idx + "."
        		   + originFileName.substring(originFileName.lastIndexOf(".")+1);
           
           idx++;
           
           //파일 저장 위치
           savePath += "/" + renameFileName;
           
           //파일에 대한 정보를 map에 저장
           HashMap<String, String> map = new HashMap<>();
           map.put("ufOriginFileName", originFileName);
           map.put("ufStoredFileName", renameFileName);
           map.put("ufSavePath", savePath);
           
           //완성된 map을 list에 담음 
           filedate.add(map);
           
           //사용자가 등록한 파일의 이름으로 빈 파일을 생성
           File fileData = new File(savePath);
           try {
        	   
              //생성된 빈파일을 사용해 사용자가 업로드한 파일을 저장
              mf.transferTo(fileData);
              
           	} catch (Exception e) {
           		e.printStackTrace();
           		throw new FileException("F_ERROR_01");
           }
           
        }
		
		return filedate;
	
	 }
	
	
	
	public void deleteFile(String path) {
		
		//삭제학 싶은 파일의 경로를 생성자의 매개변수로 넣음
		File file = new File(path);
		
		//해당 파일 삭제
		file.delete();
	}

	
}

















