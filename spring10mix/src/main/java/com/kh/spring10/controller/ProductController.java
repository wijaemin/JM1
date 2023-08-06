package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10.dao.ProductDao;
import com.kh.spring10.dto.ProductDto;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductDao dao;
	
	@RequestMapping("/detail")
	public String detail(@RequestParam int no, Model model) {
		ProductDto dto=dao.selectOne(no);
		model.addAttribute("dto",dto);
		return("/WEB-INF/views/product/detail.jsp");
	}
	@RequestMapping("/list")
	public String list(Model model) {
		List<ProductDto>list=dao.selectList();
		model.addAttribute("list",list);
		return("/WEB-INF/views/product/list.jsp");
	}
	@GetMapping("/add")
	public String add() {
		return("/WEB-INF/views/product/add.jsp");
	}
	@PostMapping("/add")
	public String add(@ModelAttribute ProductDto dto) {
		int no=dao.sequence();
		dto.setNo(no);
		dao.insert(dto);
		return"redirect:detail?no=" +no;
	}
	@GetMapping("/edit")
	public String edit(@RequestParam int no, Model model) {
		ProductDto dto=dao.selectOne(no);
		model.addAttribute("dto",dto);
		return("/WEB-INF/views/product/edit.jsp");
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute ProductDto dto) {
	boolean result=dao.update(dto);
		if(result) return "redirect:detail?no="+dto.getNo();
		else return "redirect:모름";
	}
	@RequestMapping("/delete")
	public String delete(@RequestParam int no) {
		boolean result=dao.delete(no);
		if(result) return "redirect:list";
		else return "redirect:모름";
	}
	
}
