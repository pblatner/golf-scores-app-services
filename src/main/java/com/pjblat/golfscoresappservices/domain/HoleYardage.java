package com.pjblat.golfscoresappservices.domain;

public class HoleYardage
{
	private Integer id;
	private Integer holeNumber;
	private Integer yardage;
	private Integer par;
	
	public HoleYardage(Integer id, Integer holeNumber, Integer par, Integer yardage)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.yardage = yardage;
		this.par = par;
	}

	public HoleYardage()
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

	public Integer getYardage()
	{
		return yardage;
	}

	public void setYardage(Integer yardage)
	{
		this.yardage = yardage;
	}

	public Integer getPar()
	{
		return par;
	}

	public void setPar(Integer par)
	{
		this.par = par;
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
