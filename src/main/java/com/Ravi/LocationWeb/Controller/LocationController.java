package com.Ravi.LocationWeb.Controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ravi.LocationWeb.Entity.Location;
import com.Ravi.LocationWeb.Repo.LocationRepo;
import com.Ravi.LocationWeb.Service.ILocationService;
import com.Ravi.LocationWeb.Util.IReportUtil;
import com.Ravi.LocationWeb.Util.ISendLocationEmail;

@Controller
public class LocationController {
	
	@Autowired
	ILocationService locService;
	
	@Autowired
	ISendLocationEmail sendLocEmail;
	
	@Autowired
	IReportUtil report;
	
	@Autowired
	ServletContext servContext;
	
	@Autowired
	LocationRepo repo;
	
	@RequestMapping("/createLocation")
	public String createLocation() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLoc(@ModelAttribute("location") Location location,ModelMap map) {
		Location loc = locService.saveLocation(location);
		String msg = loc.getId()+" location saved successfully";
		map.addAttribute("message", msg);
		//Sending mail
		sendLocEmail.sendLocationEmail("ravilankalapalli@gmail.com", "Location status", msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayAllLocations")
	public String displayAllLocations(ModelMap map) {
		List<Location> locList = locService.allLocations();
		map.addAttribute("LocationList", locList);
		return "displayLocations";
	}
	 
	@RequestMapping("/deleteLocation")
	public String deleteLoc(@RequestParam(name = "id",required = true) Long id,ModelMap map) {
		Location location = locService.getLocationById(id);
		locService.deleteLocation(location);
		List<Location> locList = locService.allLocations();
		map.addAttribute("LocationList", locList);
		return "displayLocations";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@RequestParam(name="id") Long id,ModelMap map) {
		Location location = locService.getLocationById(id);
		map.addAttribute("updateLocation", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateOneLocation(@ModelAttribute("location") Location location,ModelMap map) {
		System.out.println("Inside update");
		Location upLoc = locService.updateLocation(location);
		String strLoc=upLoc.getId()+" record updated successfully";
		map.addAttribute("LocationList", strLoc);
		return "createLocation";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport(ModelMap map) {
		String fName = String.valueOf(System.currentTimeMillis()) + "Location.jpeg";
	    File file = new File(servContext.getRealPath("/WEB-INF/Reports/"+fName));
	    System.out.println("Hello  "+file.getAbsolutePath());
		List<Object[]> dataReport = repo.getAllDatReport();
		report.reportGenerate("Capacity Report", dataReport,file);
		List<Location> locList = locService.allLocations();
		map.addAttribute("LocationList", locList);
		return "displayLocations";
	}
	
}
