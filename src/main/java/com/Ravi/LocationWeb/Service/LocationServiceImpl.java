package com.Ravi.LocationWeb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ravi.LocationWeb.Entity.Location;
import com.Ravi.LocationWeb.Repo.LocationRepo;

@Service
public class LocationServiceImpl implements ILocationService {

	@Autowired
	LocationRepo locRepo;
	
	
	public LocationRepo getLocRepo() {
		return locRepo;
	}

	public void setLocRepo(LocationRepo locRepo) {
		this.locRepo = locRepo;
	}

	@Override
	public Location saveLocation(Location location) {
		return locRepo.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return locRepo.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		locRepo.delete(location);

	}

	@Override
	public List<Location> allLocations() {
		return locRepo.findAll();
	}

	@Override
	public Location getLocationById(long id) {
		// TODO Auto-generated method stub
		return locRepo.getOne(id);
	}


}
