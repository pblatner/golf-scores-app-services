package com.pjblat.golfscoresappservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pjblat.golfscoresappservices.dao.CourseDaoService;
import com.pjblat.golfscoresappservices.domain.Course;
import com.pjblat.golfscoresappservices.exception.CourseNotFoundException;

/*
 * 
 * APIs Needed
 * - GET /golfers
 *   - get a list of all the golfers, each with an average score
 *   
 * - GET /golfers/{id}
 *   - get a single golfer with a list of all this golfers score
 *   
 * - POST /golfers
 *   - create a single golfer, with basic attributes (no scores)
 * 
 * - GET /courses
 *   - retrieve a list of all the courses in the system with no aggregate data
 *   
 * - GET /courses/{id}
 *   - get a single course with the sets of Tees and a count of the number of rounds played
 * 
 * - Create a round score for a single golfer with individual hole scores
 * 
 *
 */

@RestController
public class GolfScoresController
{
	@Autowired
	private CourseDaoService service;
	
	@GetMapping("/courses")
	public List<Course> retrieveAllCourses() 
	{
		return service.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Course retrieveCourse(@PathVariable int id) 
	{
		Course c = service.findOne(id);
		if (c == null) {
			throw new CourseNotFoundException("id-"+id);
		}
		
		return c;
	}
}
