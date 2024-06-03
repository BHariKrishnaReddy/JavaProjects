package com.example.restfulWebService.restfulWebServices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
	
	@GetMapping("/v1/person")
	public PersonV1 getFirstvp() {
		return new PersonV1("Harikrisna");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondvp() {
		return new PersonV2(new Name("Harikrisna","Reddy"));
	}

	
	@GetMapping(path = "/person",params="v1")
	public PersonV1 getFirstvpRequestParam() {
		return new PersonV1("Harikrisna");
	}

	@GetMapping(path = "/person", params = "v2")
	public PersonV2 getSecondvpRequestParam() {
		return new PersonV2(new Name("Harikrisna","Reddy"));
	}
	
	@GetMapping(path = "/person/header",headers ="X-API-VERSION=1")
	public PersonV1 getFirstvpHeader() {
		return new PersonV1("Harikrisna");
	}

	@GetMapping(path = "/person/header", headers = "-API-VERSION=2")
	public PersonV2 getSecondvpHeader() {
		return new PersonV2(new Name("Harikrisna","Reddy"));
	}

}
