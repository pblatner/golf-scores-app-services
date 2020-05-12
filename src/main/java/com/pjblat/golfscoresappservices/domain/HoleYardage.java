package com.pjblat.golfscoresappservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "hole_yardage")
public class HoleYardage
{
	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Column(name = "hole_number")
	private Integer holeNumber;
	
	@NotNull
	@Column(name = "hole_yardage")
	private Integer yardage;
	
	@NotNull
	@Column(name = "par")
	private Integer par;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tee_set_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private TeeSet teeSet;
	
	public HoleYardage(Integer id, Integer holeNumber, Integer par, Integer yardage)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.yardage = yardage;
		this.par = par;
	}
	public HoleYardage(Integer id, Integer holeNumber, Integer par, Integer yardage, TeeSet teeSet)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.yardage = yardage;
		this.par = par;
		this.teeSet = teeSet;
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
	public TeeSet getTeeSet()
	{
		return teeSet;
	}

	public void setTeeSet(TeeSet teeSet)
	{
		this.teeSet = teeSet;
	}

	
	
	
}
