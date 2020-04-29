package com.pjblat.golfscoresappservices.domain;

import java.util.List;

public class Golfer
{
	private Integer id;
	private String firstName;
	private String lastName;
	private String emailAddress;
	
	private List<Round> roundsPlayed;
	
	public Golfer(Integer id, String firstName, String lastName, String emailAddress)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
	}

	public Golfer()
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

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmailAddress()
	{
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	public List<Round> getRoundsPlayed()
	{
		return roundsPlayed;
	}

	public void setRoundsPlayed(List<Round> roundsPlayed)
	{
		this.roundsPlayed = roundsPlayed;
	}
	
	
}
