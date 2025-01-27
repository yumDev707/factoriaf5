package com.factoriaf5.jenniferDiez_factoriaF5;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.factoriaf5.jenniferDiez_factoriaF5.valueObjects.ImagesVO;

@SpringBootTest
class JenniferDiezFactoriaF5ApplicationTests {

	@Autowired
	ImagesService imgService;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testVoidImagesList() {
		assertEquals(0, imgServices.count());
	}

	@Test
	public void testSaveImage() {
		ImagesVO img = new ImagesVO(1, "Title", "URL");
		imgServices.save(img);
		assertEquals(1, imgServices.count());
		
		ImagesVO savedImg = imgServices.findById(1);
		assertNotNull(savedImg);
	    assertEquals("Title", savedImage.getTitle());
	    assertEquals("URL", savedImage.getUrl());
	}
	
	@Test
	public void testImagesList() {
		assertEquals(1, imgServices.count());
	}
	
	@Test
	public void testEditImage() {
		ImagesVO img = imgServices.findById(1);
		img.setTitle("New title");
		img.setUrl("New url");
		imgServices.update(img);
		
		assertEqual("New title", img.getTitle());
		assertEqual("New url", img.getUrl());
	}
	
	@Test
	public void testDeleteImage() {
		imgServices.delete(1);
		assertEquals(0, imgServices.count());		
	}
}