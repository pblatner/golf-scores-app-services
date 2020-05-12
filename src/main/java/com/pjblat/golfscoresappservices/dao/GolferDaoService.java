package com.pjblat.golfscoresappservices.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pjblat.golfscoresappservices.domain.Course;
import com.pjblat.golfscoresappservices.domain.Golfer;

@Component
@Repository
@Transactional
public class GolferDaoService
{
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Golfer> findAll()
	{
		List<Golfer> golfers = (List<Golfer>) entityManager.createQuery("SELECT g from Golfer g").getResultList();
		return golfers;
	}
	
	public Golfer findOne(int id)
	{
		return entityManager.find(Golfer.class, id);
	}
}
