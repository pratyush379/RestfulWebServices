package com.pratyush.restfulwebservice.helloworld;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

//	@RequestMapping(method= RequestMethod.GET , path="/hello-world")
//	public String helloWorld() {
//		return "hello world";
//	}
	
	
	private MessageSource messageSource; 
	
	public HomeController(MessageSource messageSource){
		this.messageSource = messageSource;
	}
	
	@GetMapping("hello-world")
	public String helloWorld() {
		return "hello world";
	}
	
	
	//bean to json
	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("hello duniya");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format(name));
	}
	
	@GetMapping("hello-world-international")
	public String helloWorldInternalitionalization() {
		Locale locale = LocaleContextHolder.getLocale();
	 return messageSource.getMessage("good.morning.message", null, "Default Message",locale);
	//return "hello world v2";	
	}
	
	
	
}
