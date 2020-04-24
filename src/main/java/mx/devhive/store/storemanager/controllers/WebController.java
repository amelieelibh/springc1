package mx.devhive.store.storemanager.controllers;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@Autowired
	private BuildProperties buildProperties;
	@Value("${spring.application.buildtime}")
	private String buildTime;
	@Value("${spring.application.comment}")
	private String[] comment;
	@Autowired
	private Environment environment;
	
	@RequestMapping(value = {"/", "/index", "/index.html", "/index.htm"})
	public String home() {
		return "index";
	}
	

	@RequestMapping({"/hello"})
	public String inicio(HttpSession session) {
		session.setAttribute("buildTime", buildTime);
		session.setAttribute("comment", (comment != null ?
				Arrays.stream(comment).collect(Collectors.toList()) 
				: "null"));
		session.setAttribute("environment", (environment != null ?
				Arrays.stream(environment.getActiveProfiles()).collect(Collectors.toList()) 
				: "null"));
		session.setAttribute("buildProperties", buildProperties);
		
		return "hello-page";
	}
}
