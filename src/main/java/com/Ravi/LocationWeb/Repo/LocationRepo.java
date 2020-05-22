package com.Ravi.LocationWeb.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Ravi.LocationWeb.Entity.Location;


@Repository
public interface LocationRepo extends JpaRepository<Location, Long> {
	
	@Query("select type,count(type) from Location group by type")
	public List<Object[]> getAllDatReport();
}
