package de.okaycloud.HelloWorldWebapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random; 


@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		Random rand = new Random(); 
		int rand_int1 = rand.nextInt(100); 
		return "Die Helga ("+rand_int1+ " Jahre), die mag ich sehr.!";
	}

}

