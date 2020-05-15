package com.pjblat.golfscoresappservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hole_score")
public class HoleScore
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;
	
	@NotNull
	@Column(name = "hole_number")
	private Integer holeNumber;
	
	@NotNull
	@Column(name = "number_of_strokes")
	private Integer numberOfStrokes;
	
	@NotNull
	@Column(name = "number_of_putts")
	private Integer numberOfPutts;
	
	@Column(name = "out_of_bounds", columnDefinition = "BOOLEAN")
	private Boolean outOfBounds;
	
	@Column(name = "water_hazard", columnDefinition = "BOOLEAN")
	private Boolean waterHazard;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "round_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Round round;
	
	
	// need to decide what to do with the HoleYardage reference:  id or obj reference
	// private 
	
	public HoleScore(Integer id, Integer holeNumber, Integer numberOfStrokes, Integer numberOfPutts, boolean outOfBounds,
			boolean waterHazard)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.numberOfStrokes = numberOfStrokes;
		this.numberOfPutts = numberOfPutts;
		this.outOfBounds = outOfBounds;
		this.waterHazard = waterHazard;
	}
	public HoleScore(Integer id, Integer holeNumber, Integer numberOfStrokes, Integer numberOfPutts, boolean outOfBounds,
			boolean waterHazard, Round round)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.numberOfStrokes = numberOfStrokes;
		this.numberOfPutts = numberOfPutts;
		this.outOfBounds = outOfBounds;
		this.waterHazard = waterHazard;
		this.round = round;
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
	public Round getRound()
	{
		return round;
	}
	public void setRound(Round round)
	{
		this.round = round;
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
