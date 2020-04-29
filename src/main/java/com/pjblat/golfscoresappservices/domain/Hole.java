package com.pjblat.golfscoresappservices.domain;

import java.util.List;

public class Hole
{
	private Integer id;
	private Integer holeNumber;
	private List<HoleYardage> yardages;
	
	public Hole(Integer id, Integer holeNumber, List<HoleYardage> yardages)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.yardages = yardages;
	}
	public Hole()
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
	public List<HoleYardage> getYardages()
	{
		return yardages;
	}
	public void setYardages(List<HoleYardage> yardages)
	{
		this.yardages = yardages;
	}
	public Integer getHoleNumber()
	{
		return holeNumber;
	}
	public void setHoleNumber(Integer holeNumber)
	{
		this.holeNumber = holeNumber;
	}
	
	
}
