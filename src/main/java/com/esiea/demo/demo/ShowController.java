package com.esiea.demo.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/shows")
public class ShowController {

	@Autowired
	private final ShowService service;
	
	public ShowController(ShowService service) {
		this.service = service;
	}
	
	@GetMapping("/all")
	public List<Show> getMethodName() {
		return service.getAll();
	}
	

	
	@GetMapping("/{id}")
	public ResponseEntity<Show> getMethodName(@PathVariable int id) {
        return ResponseEntity.ok(service.get(id));
	}
	
}
