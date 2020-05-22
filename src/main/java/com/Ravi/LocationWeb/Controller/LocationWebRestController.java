package com.Ravi.LocationWeb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ravi.LocationWeb.Entity.Location;
import com.Ravi.LocationWeb.Repo.LocationRepo;

@RestController
@RequestMapping("/Locations")
public class LocationWebRestController {
	
	@Autowired
	LocationRepo locRepo;
	
	@GetMapping
	public List<Location> getLocations() {
		return locRepo.findAll();
	}
	
	@PostMapping
	public Location addLocation(@RequestBody Location location) {
		return locRepo.save(location);
	}
	
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		return locRepo.save(location);
	}
	
	@GetMapping("/{id}")
	public Location getOneLocation(@PathVariable("id") long id) {
		return locRepo.findById(id).get();
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneLocation(@PathVariable("id") long id) {
		locRepo.deleteById(id);
	}
	
	@PatchMapping
	public Location UpdateSomeRecords(@RequestBody Location location) {
		return locRepo.save(location);
	}
	
}
