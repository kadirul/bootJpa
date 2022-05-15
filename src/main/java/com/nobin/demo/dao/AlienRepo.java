/**
 * 
 */
package com.nobin.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nobin.demo.model.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer> {

	List<Alien> findAllByTech(String string);

	List<Alien> findByIdGreaterThan(int i);
	
	@Query("FROM Alien WHERE id=?1")
	List<Alien> findByTechSorted(int id);

}
