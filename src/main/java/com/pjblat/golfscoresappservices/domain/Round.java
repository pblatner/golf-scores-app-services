package com.pjblat.golfscoresappservices.domain;

import java.util.Date;
import java.util.List;

public class Round
{
	private Integer id;
	private Date datePlayed;
	private List<HoleScore> holesPlayed;
	
	// need to decide what to do with the course played:  id or obj reference
	// private Course coursePlayed;
	// private TeeSet teeSetPlayed;
	
	public Round(Integer id, Date datePlayed, List<HoleScore> holesPlayed)
	{
		super();
		this.id = id;
		this.datePlayed = datePlayed;
		this.holesPlayed = holesPlayed;
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
	
	
}
