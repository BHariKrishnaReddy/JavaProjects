package com.example.restfulWebService.restfulWebServices.helloworld;


import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorldController {
	
	private MessageSource messageSource;
	
	private helloWorldController(MessageSource messageSource) {
		this.messageSource = messageSource ;
	}
	
	@GetMapping(path="/hello-world")
	public String helloworld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-worldBean")
	public helloworldBean helloworldBean() {
		return new helloworldBean("Hello World");
	}
	
	@GetMapping(path="/hello-world/pathVar/{name}")
	public helloworldBean helloworlPathVariable(@PathVariable String name) {
		return new helloworldBean(String.format("Hello World, %s", name));
	}

	
	@GetMapping(path="/hello-world-i18n")
	public String helloworldI18n() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default", locale);
	}
}
