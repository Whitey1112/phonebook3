package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PhonebookController {
	
	//필드
	
	//생성자
	
	//메소드gs
	
	//메소드 일반

	//등록폼
	@RequestMapping(value="/writeform", method = {RequestMethod.GET, RequestMethod.POST})
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		return "/WEB-INF/views/writeform.jsp";
	}
	
	//등록
	
	//리스트
	
}
