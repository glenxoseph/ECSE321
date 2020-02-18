package ca.mcgill.ecse321.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import ca.mcgill.ecse321.backend.jpa.*;

@RestController
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@RequestMapping("/")
	public String greeting(){
		return "Hello this is our frontend web application";
	}

}
