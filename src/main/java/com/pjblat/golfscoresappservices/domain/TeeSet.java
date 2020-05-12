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
@Table(name = "tee_set")
public class TeeSet
{
	@Id
	@GeneratedValue
	private Integer id;

	@NotNull
	@Column(name = "name")
	private String name;
	
	@Column(name = "slope")
	private Integer slope;
	
	@Column(name = "rating")
	private Float rating;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
	private Course course;
	
	public TeeSet(Integer id, String name, Integer slope, Float rating)
	{
		super();
		this.id = id;
		this.name = name;
		this.slope = slope;
		this.rating = rating;
	}
	public TeeSet(Integer id, String name, Integer slope, Float rating, Course course)
	{
		super();
		this.id = id;
		this.name = name;
		this.slope = slope;
		this.rating = rating;
		this.course = course;
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
	public Integer getSlope()
	{
		return slope;
	}
	public void setSlope(Integer slope)
	{
		this.slope = slope;
	}
	public Float getRating()
	{
		return rating;
	}
	public void setRating(Float rating)
	{
		this.rating = rating;
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
