package com.factoriaf5.jenniferDiez_factoriaF5.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
	
	String directory = "src/main/resources/static/images/gallery/";
	
	@GetMapping("")
	public String index(Model model) {
		List<ImagesVO> totalImages = imgSrv.findAll();
		model.addAttribute("totalImages", totalImages);
		
		model.addAttribute("image", new ImagesVO());
		return "index";
	}

	@PostMapping("/addImage")
	public String addImage(@ModelAttribute ImagesVO img, @RequestParam("imageFile") MultipartFile imageFile) {	    
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
		ImagesVO img = imgSrv.findById(id).get();
		String imgPath = directory + img.getUrl();
		File imageFile = new File(imgPath);
		try {
			if(imageFile.exists()) {
				imageFile.delete();
			} else {
				System.out.println("Error deleting image in the folder.");
			}
			imgSrv.delete(imgSrv.findById(id).get());
		} catch (Exception e) {
			
		}
		return "redirect:/index";
	}
	
	@PostMapping("/editImage")
	public String editImage(@ModelAttribute ImagesVO img, @RequestParam("imageFile") MultipartFile imageFile) {
	    try {
	        ImagesVO existingImage = imgSrv.findById(img.getId()).orElseThrow(() -> new IllegalArgumentException("Imagen no encontrada"));
	        if (!imageFile.isEmpty()) {
	            String fileName = imageFile.getOriginalFilename();
	            Path filePath = Paths.get(directory, fileName);
	            Files.write(filePath, imageFile.getBytes());
	            existingImage.setUrl(fileName);
	        }

	        if (img.getTitle() != null && !img.getTitle().isEmpty()) {
	            existingImage.setTitle(img.getTitle());
	        }

	        imgSrv.save(existingImage);
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	        return "redirect:/index?error=true";
	    }
	    return "redirect:/index";
	}

}