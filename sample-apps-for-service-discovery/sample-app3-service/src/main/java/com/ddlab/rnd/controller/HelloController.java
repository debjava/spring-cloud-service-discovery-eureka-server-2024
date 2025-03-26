package com.ddlab.rnd.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping(path="/hello/{id}")
	public ResponseEntity<String> getHelloById(@PathVariable("id") String id) {
		return ResponseEntity.ok("Hello-"+id);
	}

}
