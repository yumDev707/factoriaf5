package com.factoriaf5.jenniferDiez_factoriaF5.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.factoriaf5.jenniferDiez_factoriaF5.services.ImagesService;
import com.factoriaf5.jenniferDiez_factoriaF5.valueObjects.ImagesVO;


@Controller
@RequestMapping("")
public class IndexController {
	@Autowired
	ImagesService imgSrv;
	
	@RequestMapping("")
	public String index(Model model) {
		List<ImagesVO> totalImages = imgSrv.findAll();
		model.addAttribute("totalImages", totalImages);
		return "index";
	}
}
