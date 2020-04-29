package de.okaycloud.HelloWorldWebapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Die Helga, die mag ich sehr.!";
	}

}

