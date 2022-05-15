/**
 * 
 */
package com.nobin.demo.controller;

import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.nobin.demo.dao.AlienRepo;
import com.nobin.demo.model.Alien;

/**
 * @author kadir
 *
 */
@RestController
public class AlienController {

	@Autowired
	AlienRepo repo;

	@RequestMapping("/")
	public String show() {
		return "home.jsp";
	}

	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		repo.save(alien);
		return "home.jsp";
	}

	@RequestMapping("/getAlien")
	public ModelAndView getAlien(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("showAlien.jsp");
		Alien alien = repo.findById(id).orElse(new Alien());

		System.out.println(repo.findAllByTech("Java"));
		System.out.println(repo.findByIdGreaterThan(102));
		System.out.println(repo.findByTechSorted(101));

		mv.addObject(alien);
		return mv;
	}

	@RequestMapping("/alien")
	public List<Alien> Alien() {
		return repo.findAll();

	}

	@RequestMapping("/alien/{id}")
	public Optional<Alien> AlienId(@PathVariable("id") int id) {
		return repo.findById(id);

	}

	@PostMapping(path = "/saveAlien", consumes = { "application/json" })
	public Alien saveAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;

	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteAlien(@PathVariable int id) {
		Alien a = repo.getById(id);
		repo.delete(a);
		return "deleted";
	}
	
	@PutMapping(path="/update", consumes="application/json")
	public Alien updateAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
		
	}
}
