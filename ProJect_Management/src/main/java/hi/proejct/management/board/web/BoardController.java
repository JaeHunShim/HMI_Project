package hi.proejct.management.board.web;

import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import hi.proejct.management.board.service.BoardSerivce;
import hi.proejct.management.domain.Board;
import hi.proejct.management.domain.Criteria;
import hi.proejct.management.domain.FileVO;
import hi.proejct.management.domain.PageMaker;
import hi.proejct.management.domain.UserInfo;



@Controller
@RequestMapping("/board")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
 	private BoardSerivce boardService;
	
	@RequestMapping(value="/viewList", method=RequestMethod.GET)
	public String BoardListAll(HttpSession session ,Model model,Criteria cri) throws Exception{
		UserInfo userInfo = (UserInfo)session.getAttribute("session");
		model.addAttribute("board",boardService.findAll(userInfo,cri));
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.countList(userInfo));
		model.addAttribute("pageMaker",pageMaker);
		return "board/viewList";
	}
	@RequestMapping(value="/regster", method=RequestMethod.GET)
	public String regsterGet() throws Exception{

		return "board/regster";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String regsterPost(UserInfo userInfo ,Board board,FileVO fileVO,MultipartHttpServletRequest request ) throws Exception {

		boardService.register(userInfo, board, request,fileVO);
		
		return "redirect:/board/viewList";
	}
	@RequestMapping(value="/detailView",method=RequestMethod.GET)
	public String detailView(Board board, Model model) throws Exception {
		
		model.addAttribute("fileVO", boardService.detailView(board));
		logger.info("fileVO에 대한 정보:"  + boardService.detailView(board));
		
		return "board/detailView";
	}
	@RequestMapping(value="/fileDownload", method=RequestMethod.GET)
	public void downloadFile(FileVO fileVO, HttpServletResponse response) throws Exception {
		fileVO = boardService.selectFileInfo(fileVO);
		String storedFileName = fileVO.getStoredFileName();
		String originalFileName= fileVO.getOriginalFileName();
		
		byte fileByte[] = FileUtils.readFileToByteArray(new File("D:\\" + storedFileName));
		response.setContentType("application/octet-stream");
	    response.setContentLength(fileByte.length);
	    response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName,"UTF-8")+"\";");
	    response.setHeader("Content-Transfer-Encoding", "binary");
	    response.getOutputStream().write(fileByte);
	    
	    response.getOutputStream().flush();
	    response.getOutputStream().close();
		
	}
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(Board board) throws Exception {
		boardService.delete(board);
		return "redirect:/board/viewList";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public String modifyGet(Board board,Model model) throws Exception {
		
		model.addAttribute("fileVO", boardService.detailView(board));
		
		return "board/modify";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String modifyPost(Board board, FileVO fileVO) throws Exception{
		logger.info("modify정보" + board.getPno() + "fileVO정보  " + fileVO.getFileId());
		
		boardService.update(board, fileVO);
		
		return "redirect:/board/viewList";
	}
	
}
