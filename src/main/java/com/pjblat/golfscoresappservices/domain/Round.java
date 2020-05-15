package com.pjblat.golfscoresappservices.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "round")
public class Round
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer id;

	@NotNull
	@Column(name = "date_played")
	private Date datePlayed;

	@OneToMany(mappedBy="round")
	private List<HoleScore> holesPlayed;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "course_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Course coursePlayed;

	// need to decide what to do with the course played: id or obj reference
	//
	// private TeeSet teeSetPlayed;

	public Round(Integer id, Date datePlayed, List<HoleScore> holesPlayed)
	{
		super();
		this.id = id;
		this.datePlayed = datePlayed;
		this.holesPlayed = holesPlayed;
	}
	public Round(Integer id, Date datePlayed, List<HoleScore> holesPlayed, Course coursePlayed)
	{
		super();
		this.id = id;
		this.datePlayed = datePlayed;
		this.holesPlayed = holesPlayed;
		this.coursePlayed = coursePlayed;
	}
	public Round()
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

	public Date getDatePlayed()
	{
		return datePlayed;
	}

	public void setDatePlayed(Date datePlayed)
	{
		this.datePlayed = datePlayed;
	}

	public List<HoleScore> getHolesPlayed()
	{
		return holesPlayed;
	}

	public void setHolesPlayed(List<HoleScore> holesPlayed)
	{
		this.holesPlayed = holesPlayed;
	}
	public Course getCoursePlayed()
	{
		return coursePlayed;
	}
	public void setCoursePlayed(Course coursePlayed)
	{
		this.coursePlayed = coursePlayed;
	}

}
