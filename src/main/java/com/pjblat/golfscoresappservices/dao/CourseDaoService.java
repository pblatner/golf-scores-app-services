package com.pjblat.golfscoresappservices.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.pjblat.golfscoresappservices.domain.Course;
import com.pjblat.golfscoresappservices.domain.Hole;
import com.pjblat.golfscoresappservices.domain.HoleYardage;
import com.pjblat.golfscoresappservices.domain.TeeSet;

@Component
@Repository
@Transactional
public class CourseDaoService
{
	/*
	 * used for in memory testing of the services prior to DB implementation private
	 * static List<Course> courses = new ArrayList<>(); private static int
	 * coursesCount = 2;
	 */

	@Autowired
	private Environment env;

	@Value("${persist.external:n}")
	private String externalDB;

	/*
	 * used for in memory testing of the services prior to DB implementation static
	 * { Course tf = new Course(1, "Tanna Farms"); //Course tf = new Course(1,
	 * "Tanna Farms", new ArrayList<TeeSet>(), new ArrayList<Hole>());
	 * 
	 * List<HoleYardage> c1h1yardages = new ArrayList<HoleYardage>(); HoleYardage
	 * h1t1 = new HoleYardage(1001, 1, 4, 400); HoleYardage h1t2 = new
	 * HoleYardage(1002, 1, 4, 380); HoleYardage h1t3 = new HoleYardage(1003, 1, 4,
	 * 360); HoleYardage h1t4 = new HoleYardage(1004, 1, 4, 343);
	 * c1h1yardages.add(h1t1); c1h1yardages.add(h1t2); c1h1yardages.add(h1t3);
	 * c1h1yardages.add(h1t4);
	 * 
	 * List<HoleYardage> c1h2yardages = new ArrayList<HoleYardage>(); HoleYardage
	 * h2t1 = new HoleYardage(2001, 2, 3, 182); HoleYardage h2t2 = new
	 * HoleYardage(2002, 2, 3, 173); HoleYardage h2t3 = new HoleYardage(2003, 2, 3,
	 * 164); HoleYardage h2t4 = new HoleYardage(2004, 2, 3, 123);
	 * c1h2yardages.add(h2t1); c1h2yardages.add(h2t2); c1h2yardages.add(h2t3);
	 * c1h2yardages.add(h2t4);
	 * 
	 * List<HoleYardage> c1h3yardages = new ArrayList<HoleYardage>(); HoleYardage
	 * h3t1 = new HoleYardage(3001, 3, 5, 545); HoleYardage h3t2 = new
	 * HoleYardage(3002, 3, 5, 523); HoleYardage h3t3 = new HoleYardage(3003, 3, 5,
	 * 490); HoleYardage h3t4 = new HoleYardage(3004, 3, 5, 436);
	 * c1h3yardages.add(h3t1); c1h3yardages.add(h3t2); c1h3yardages.add(h3t3);
	 * c1h3yardages.add(h3t4);
	 * 
	 * List<TeeSet> c1teeSets = new ArrayList<TeeSet>(); TeeSet c1ts1 = new
	 * TeeSet(1, "Black", 120.5, 73.4); c1ts1.setHoleYardages(new
	 * ArrayList<HoleYardage>()); c1ts1.getHoleYardages().add(h1t1);
	 * c1ts1.getHoleYardages().add(h2t1); c1ts1.getHoleYardages().add(h3t1);
	 * 
	 * TeeSet c1ts2 = new TeeSet(2, "Blue", 114.0, 71.2); c1ts2.setHoleYardages(new
	 * ArrayList<HoleYardage>()); c1ts2.getHoleYardages().add(h1t2);
	 * c1ts2.getHoleYardages().add(h2t2); c1ts2.getHoleYardages().add(h3t2);
	 * 
	 * TeeSet c1ts3 = new TeeSet(3, "White", 110.8, 68.6); c1ts3.setHoleYardages(new
	 * ArrayList<HoleYardage>()); c1ts3.getHoleYardages().add(h1t3);
	 * c1ts3.getHoleYardages().add(h2t3); c1ts3.getHoleYardages().add(h3t3);
	 * 
	 * TeeSet c1ts4 = new TeeSet(3, "Red", 96.0, 65.1); c1ts4.setHoleYardages(new
	 * ArrayList<HoleYardage>()); c1ts4.getHoleYardages().add(h1t4);
	 * c1ts4.getHoleYardages().add(h2t4); c1ts4.getHoleYardages().add(h3t4);
	 * 
	 * c1teeSets.add(c1ts1); c1teeSets.add(c1ts2); c1teeSets.add(c1ts3);
	 * c1teeSets.add(c1ts4);
	 * 
	 * List<Hole> c1Holes = new ArrayList<Hole>(); c1Holes.add(new Hole(1, 1, 3));
	 * c1Holes.add(new Hole(2, 2, 5)); c1Holes.add(new Hole(3, 3, 4));
	 * 
	 * //tf.setSetsOfTees(c1teeSets); //tf.setHoles(c1Holes);
	 * 
	 * courses.add(tf); }
	 */

	public List<Course> findAll()
	{
		List<Course> courses = (List<Course>) entityManager.createQuery("SELECT c from Course c").getResultList();
		return courses;
	}

	public Course findOne(int id)
	{
		return entityManager.find(Course.class, id);
	}

	@PersistenceContext
	private EntityManager entityManager;

	public Integer insert(Course course)
	{
		entityManager.persist(course);
		return course.getId();
	}

}
