package de.okaycloud.HelloWorldWebapp;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Random; 


@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "This is the HelloWorld Webapp for the Continuous Deploment Tutorial";
	}

}

