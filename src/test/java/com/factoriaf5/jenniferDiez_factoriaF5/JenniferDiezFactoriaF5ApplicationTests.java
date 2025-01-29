package com.factoriaf5.jenniferDiez_factoriaF5;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Optional;

import com.factoriaf5.jenniferDiez_factoriaF5.services.ImagesService;
import com.factoriaf5.jenniferDiez_factoriaF5.valueObjects.ImagesVO;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class JenniferDiezFactoriaF5ApplicationTests {

	@Autowired
	ImagesService imgServices;
	
	@Test
	public void test00contextLoads() {
	}
	
	@Test
	public void test01_voidImagesList() {
		assertEquals(3, imgServices.count());
	}

	@Test
	public void test02_saveImage() {
		ImagesVO img = new ImagesVO(4, "Title", "URL");
		imgServices.save(img);
		assertEquals(4, imgServices.count());
		
		Optional<ImagesVO> savedImage = imgServices.findById(4);
	    assertEquals("Title", savedImage.get().getTitle());
	    assertNotEquals("False URL", savedImage.get().getUrl());
	}
	
	@Test
	public void test03_imagesList() {
		imgServices.save(new ImagesVO(5, "Second Title", "Second URL"));
		assertEquals(5, imgServices.count());
	}
	
	@Test
	public void test04_editImage() {
		Optional<ImagesVO> img = imgServices.findById(4);
		if(img.isPresent()) {
			img.get().setTitle("New title");
			img.get().setUrl("New url");
			imgServices.update(img);
		}
		
		assertEquals("New title", img.get().getTitle());
		assertEquals("New url", img.get().getUrl());
	}
	
	@Test
	public void test05_deleteImage() {
		Optional<ImagesVO> img = imgServices.findById(5);
	    imgServices.delete(img.get());
	    assertEquals(4, imgServices.count());	
	}
}