/**
 * 
 */
package com.nobin.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author kadir
 *
 */
@Entity
public class Alien {
	@Id
	private int id;
	private String name;
	private String tech;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the tech
	 */
	public String getTech() {
		return tech;
	}
	/**
	 * @param tech the tech to set
	 */
	public void setTech(String tech) {
		this.tech = tech;
	}
	@Override
	public String toString() {
		return "Alien [id=" + id + ", name=" + name + ", tech=" + tech + "]";
	}

	
	
}
