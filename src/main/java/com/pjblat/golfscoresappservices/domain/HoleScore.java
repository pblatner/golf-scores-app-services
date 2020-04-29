package com.pjblat.golfscoresappservices.domain;

public class HoleScore
{
	private Integer id;
	private Integer numberOfStrokes;
	private Integer numberOfPutts;
	private boolean outOfBounds;
	private boolean waterHazard;
	
	
	
	// need to decide what to do with the HoleYardage reference:  id or obj reference
	// private 
	
	public HoleScore(Integer id, Integer numberOfStrokes, Integer numberOfPutts, boolean outOfBounds,
			boolean waterHazard)
	{
		super();
		this.id = id;
		this.numberOfStrokes = numberOfStrokes;
		this.numberOfPutts = numberOfPutts;
		this.outOfBounds = outOfBounds;
		this.waterHazard = waterHazard;
	}
	public HoleScore()
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
	public Integer getNumberOfStrokes()
	{
		return numberOfStrokes;
	}
	public void setNumberOfStrokes(Integer numberOfStrokes)
	{
		this.numberOfStrokes = numberOfStrokes;
	}
	public Integer getNumberOfPutts()
	{
		return numberOfPutts;
	}
	public void setNumberOfPutts(Integer numberOfPutts)
	{
		this.numberOfPutts = numberOfPutts;
	}
	public boolean isOutOfBounds()
	{
		return outOfBounds;
	}
	public void setOutOfBounds(boolean outOfBounds)
	{
		this.outOfBounds = outOfBounds;
	}
	public boolean isWaterHazard()
	{
		return waterHazard;
	}
	public void setWaterHazard(boolean waterHazard)
	{
		this.waterHazard = waterHazard;
	}
	
	
	
}
