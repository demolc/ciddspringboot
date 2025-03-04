package com.esiea.demo.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
	
	@Autowired
	private final ShowRepository repo;
	
	public ShowService(ShowRepository repo) {
		this.repo = repo;
	}
	
	public List<Show> getAll(){
		return repo.findAll();
	}
	
	public Show get(int index) {
		return repo.findById(index).orElseThrow(() -> new RuntimeException("Show not found"));
	}

}
