package com.pjblat.golfscoresappservices.domain;

import java.util.List;

public class Course
{
	private Integer id;
	private String name;
	// eventually add in an address
	// private Address address;
	private List<TeeSet> setsOfTees;
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
