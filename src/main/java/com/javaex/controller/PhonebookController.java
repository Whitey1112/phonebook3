package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhonebookDao;
import com.javaex.vo.PersonVo;

@Controller // <- 필쑤
public class PhonebookController {

	// 필드

	// Dao를 메모리에 올린다
	@Autowired
	private PhonebookDao phonebookDao = new PhonebookDao();

	// 생성자

	// 메소드gs

	// 메소드 일반

	// 삭제
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST })
	public String delete(@RequestParam(value = "no") int no) {
		System.out.println("PhonebookController.delete()");

		// PhonebookDao의 메소드르응 이용해서 데이터를 삭제한다
		int count = phonebookDao.deletePerson(no);

		return "redirect:/list";
	}

	// 리스트
	@RequestMapping(value = "/list", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(Model model) {
		System.out.println("PhonebookController.list()");

		// PhonebookDao의 메소드를 이용해서 데이터를 가져온다
		List<PersonVo> personList = phonebookDao.getPersonList();
		System.out.println(personList);

		model.addAttribute("personList", personList);

		return "list";
	}

	// 등록폼
	@RequestMapping(value = "/writeform", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhonebookController.writeForm()");
		return "writeform";
	}

	// 등록1(2개 이상 묶어야 할 떄)
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.write()");

		// PhonebookDao의 메소드를 이용해서 저장한다
		int count = phonebookDao.insertPerson(personVo);
		System.out.println(count);

		// 리스트로 리다이렉트
		// redirect:http://localhost:8888/phonebook3/list
		return "redirect:/list";
	}

	// 등록2(파라미터 1개 씩 받을 때)
	@RequestMapping(value = "/write2", method = { RequestMethod.GET, RequestMethod.POST })
	public String write2(@RequestParam(value = "name") String name, 
						 @RequestParam(value = "hp") String hp,
						 @RequestParam(value = "company") String company) {
		System.out.println("PhonebookController.write2()");

		PersonVo personVo = new PersonVo(name, hp, company);

		System.out.println(personVo);

		return "";
	}
	
	//수정폼
	@RequestMapping(value ="/editform", method = {RequestMethod.GET, RequestMethod.POST})
	public String editform(Model model, @RequestParam(value="no")int no) {
		System.out.println("PhonebookController.editform()");
		
		// PhonebookDao의 메소드를 이용해서 저장한다
		PersonVo personVo = phonebookDao.getPersonOne(no);
		
		model.addAttribute("personVo", personVo);
		
		return "editform";
	}
	
	
	//수정
	@RequestMapping(value="/edit", method = {RequestMethod.GET, RequestMethod.POST})
	public String edit(@ModelAttribute PersonVo personVo) {
		System.out.println("PhonebookController.edit()");
		
		phonebookDao.updatePerson(personVo);
		
		return "redirect:/list";
	}
	
	

}
