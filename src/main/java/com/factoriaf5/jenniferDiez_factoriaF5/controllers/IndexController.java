package com.factoriaf5.jenniferDiez_factoriaF5.controllers;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.factoriaf5.jenniferDiez_factoriaF5.services.ImagesService;
import com.factoriaf5.jenniferDiez_factoriaF5.valueObjects.ImagesVO;


@Controller
@RequestMapping("/index")
public class IndexController {
	@Autowired
	ImagesService imgSrv;
	
	@GetMapping("")
	public String index(Model model) {
		List<ImagesVO> totalImages = imgSrv.findAll();
		model.addAttribute("totalImages", totalImages);
		
		model.addAttribute("image", new ImagesVO());
		return "index";
	}

	@PostMapping("/addImage")
	public String addImage(@ModelAttribute ImagesVO img, @RequestParam("imageFile") MultipartFile imageFile) {
	    String directory = "src/main/resources/static/images/gallery/";
	    
	    try {
	        if (!imageFile.isEmpty()) {
	            String fileName = imageFile.getOriginalFilename();
	            Path filePath = Paths.get(directory, fileName);
	            imageFile.transferTo(filePath);
	            img.setUrl(fileName);
	        }
	        imgSrv.save(img);
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "redirect:/index?error=true";
	    }

	    return "redirect:/index";
	}
	
	@RequestMapping("/deleteImage")
	public String deleteImage(@RequestParam int id) {
		imgSrv.delete(imgSrv.findById(id).get());
		return "redirect:/index";
	}
}
