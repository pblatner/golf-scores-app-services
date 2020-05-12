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

// Adding some comment

@Entity
@Table(name = "hole")
public class Hole
{
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotNull
	@Column(name = "hole_number")
	private Integer holeNumber;
	
	@NotNull
	@Column(name = "par")
	private Integer basePar;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Course course;
	
	public Hole(Integer id, Integer holeNumber, Integer basePar)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.basePar = basePar;
	}
	public Hole(Integer id, Integer holeNumber, Integer basePar, Course course)
	{
		super();
		this.id = id;
		this.holeNumber = holeNumber;
		this.basePar = basePar;
		this.course = course;
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
	public Course getCourse()
	{
		return course;
	}
	public void setCourse(Course course)
	{
		this.course = course;
	}
	
	
}
