package com.spring.web5.exception;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 웹 애플리케이션의 공통 예외 처리 클래스
 */
@ControllerAdvice
public class Web5ExceptionHandler {
	/**
	 * 모든 종류의 예외를 처리
	 * @return JSP 파일 경로
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String errorHandler_404(Model model) {
		model.addAttribute("errorMsg", "404 error");
		return "/error";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String errorHandler_500(Model model) {
		model.addAttribute("errorMsg", "500 error");
		return "/error";
	}
}
