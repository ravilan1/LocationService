package com.Ravi.LocationWeb.Service;

import java.util.List;

import com.Ravi.LocationWeb.Entity.Location;


public interface ILocationService {
	
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void 	 deleteLocation(Location location);
	Location getLocationById(long id);
	List<Location> allLocations();
}
