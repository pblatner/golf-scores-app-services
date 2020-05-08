package com.pjblat.golfscoresappservices.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "course")
public class Course
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "name")
	private String name;
	// eventually add in an address
	// private Address address;
	
	@Transient
	private List<TeeSet> setsOfTees;
	
	@Transient
	private List<Hole> holes;
	
	public Course(Integer id, String name, List<TeeSet> setsOfTees, List<Hole> holes)
	{
		super();
		this.id = id;
		this.name = name;
		this.setsOfTees = setsOfTees;
		this.holes = holes;
	}
	public Course()
	{
		super();
	}
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public List<TeeSet> getSetsOfTees()
	{
		return setsOfTees;
	}
	public void setSetsOfTees(List<TeeSet> setsOfTees)
	{
		this.setsOfTees = setsOfTees;
	}
	public List<Hole> getHoles()
	{
		return holes;
	}
	public void setHoles(List<Hole> holes)
	{
		this.holes = holes;
	}
	
}
