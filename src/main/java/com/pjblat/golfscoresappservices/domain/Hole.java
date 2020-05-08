package com.pjblat.golfscoresappservices.domain;

// Adding some comment

public class Hole
{
	private Integer id;
	private Integer holeNumber;
	private Integer basePar;
	
	public Hole(Integer id, Integer holeNumber, Integer basePar)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.basePar = basePar;
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
	public Integer getHoleNumber()
	{
		return holeNumber;
	}
	public void setHoleNumber(Integer holeNumber)
	{
		this.holeNumber = holeNumber;
	}
	public Integer getBasePar()
	{
		return basePar;
	}
	public void setBasePar(Integer basePar)
	{
		this.basePar = basePar;
	}
	
	
}
