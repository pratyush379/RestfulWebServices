package com.pratyush.restfulwebservice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	
	@GetMapping("/v1/person")
	public PersonV1 getFirstVersionOfPerson() {
		return new PersonV1("Pratyush Singh");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getSecondVersionOfPerson() {
		Name name = new Name("Pratyush", "Singh");
		return new PersonV2(name);
	}
	
	@GetMapping(path="/person",params="version=2")
	public PersonV2 getSecondVersionOfPerson2() {
		Name name = new Name("Pratyush", "Singh");
		return new PersonV2(name);
	}
	
	@GetMapping(path="/person",headers="x-api-version=2")
	public PersonV2 getSecondVersionOfPerson3() {
		Name name = new Name("Pratyush", "Singh");
		return new PersonV2(name);
	}
	
	@GetMapping(path="/person",produces="application/vnd.company.app-v1+json")
	public PersonV2 getSecondVersionOfPerson4() {
		Name name = new Name("Pratyush", "Singh");
		return new PersonV2(name);
	}
}
