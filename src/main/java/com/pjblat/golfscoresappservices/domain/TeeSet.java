package com.pjblat.golfscoresappservices.domain;

import java.util.List;

public class TeeSet
{
	private Integer id;
	private String name;
	private Double slope;
	private Double rating;
	private List<HoleYardage> holeYardages;
	
	public TeeSet(Integer id, String name, Double slope, Double rating)
	{
		super();
		this.id = id;
		this.name = name;
		this.slope = slope;
		this.rating = rating;
	}
	public TeeSet()
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
	public Double getSlope()
	{
		return slope;
	}
	public void setSlope(Double slope)
	{
		this.slope = slope;
	}
	public Double getRating()
	{
		return rating;
	}
	public void setRating(Double rating)
	{
		this.rating = rating;
	}
	public List<HoleYardage> getHoleYardages()
	{
		return holeYardages;
	}
	public void setHoleYardages(List<HoleYardage> holeYardages)
	{
		this.holeYardages = holeYardages;
	}
	
	
}
