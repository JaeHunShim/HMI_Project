package hi.proejct.management.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.FileVO;

@Component("fileUtil")
public class FileUtil {
	private static final Logger logger = LoggerFactory.getLogger(FileUtil.class);
	
	private static final String filepath="D:\\";
	
	public void parseInsertFileInfo(Board board,FileVO fileVO,MultipartHttpServletRequest request) throws Exception {
		
		Iterator<String> iterator = request.getFileNames();
		logger.info("파일이름: " + iterator);
		
		MultipartFile multipartFile = null;
		String originalFileName = null;
		String originalFileExtension= null;
		String storedFileName = null;
		
		File file = new File(filepath);
		
		if(file.exists() == false) {
			file.mkdirs();
		}
		multipartFile = request.getFile(iterator.next());
		
		if(multipartFile.isEmpty() == false) {
			
			originalFileName= multipartFile.getOriginalFilename();
			originalFileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
			storedFileName = CommonUtils.getRandomString() + originalFileExtension;
			
			file = new File(filepath + storedFileName);
			multipartFile.transferTo(file); //file 저장
			
			fileVO.setBoard(board);
			fileVO.setCreateDate(new Date(System.currentTimeMillis()));
			fileVO.setFileSize(multipartFile.getSize());
			fileVO.setOriginalFileName(originalFileName);
			fileVO.setStoredFileName(storedFileName);
			
		}
	}
	
}
