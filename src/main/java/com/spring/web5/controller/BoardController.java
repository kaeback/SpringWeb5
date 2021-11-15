package com.spring.web5.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.web5.dao.BoardDAO;
import com.spring.web5.util.FileService;
import com.spring.web5.vo.Board;

/**
 * 게시판 컨트롤러
 * 글쓰기, 읽기, 목록, 삭제, 수정
 */

@Controller
@RequestMapping("board")
public class BoardController {
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardDAO dao;		// 게시판 관련 데이터 처리 객체
	
	// 게시판 관련 상수값
	final int countPerPage = 10;				// 페이지 당 글 수
	final int pagePerGroup = 5;					// 페이지 이동 그룹 당 표시할 페이지 수
	final String uploadPath = "/boardfile";		// 파일 업로드 경로
	
	/**
	 * 글쓰기 폼 보기
	 */
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String writeForm() {
		return "board/writeForm";
	}
	
	/**
	 * 글 저장 처리
	 * @param board 사용자가 입력한 글 내용
	 */
	
	public String write(Board board, MultipartFile upload, HttpSession session, Model model) {
		// 세션에서 로그인 한 사용자의 아이디를 읽어서 Board 객체의 작성자 정보에 세팅
		String id = (String) session.getAttribute("loginId");
		board.setId(id);
		
		// 첨부파일이 있는 경우 지정된 경로에 저장하고,
		// 원본 파일명과 저장된 파일명을 Board 객체에 세팅
		if (!upload.isEmpty()) {
			String savedfile = FileService.saveFile(upload, uploadPath);
			board.setOriginalfile(upload.getOriginalFilename());
			board.setSavedfile(savedfile);
		}
		
		dao.insert(board);
		
		return "redirect:list";
	}
	
	/**
	 * 글 목록
	 * @param page 현제 페이지. 없으면 1로 처리
	 * @param searchText 검색어. 없으면 ""로 처리
	 */
	
	
	/**
	 * 글 읽기
	 * @param boardnum 읽을 글 번호
	 * @return 해당 글 정보
	 */
	
	
	/**
	 * 파일 다운로드
	 * @param boardnum 파일이 첨부된 글 번호
	 */
	
	
	/**
	 * 글 삭제
	 * @param boardnum 삭제할 글 번호
	 */
	
	
	/**
	 * 글 수정 폼으로 이동
	 * @param boardnum 수정할 글 번호
	 * @return 해당 번호의 글 정보
	 */
	
	
	/**
	 * 글 수정 처리
	 * @param board 수정할 글 정보
	 */
	
	
	/**
	 * 리플 저장 처리
	 * @param reply 사용자가 입력한 글 내용
	 */
	
	
	/**
	 * 리플 삭제
	 * @param reply 삭제할 리플 번호와 본문 글번호가 전달
	 */
	
	
	/**
	 * 리플 수정 처리
	 * @param reply 수정할 리플 정보
	 */
}
