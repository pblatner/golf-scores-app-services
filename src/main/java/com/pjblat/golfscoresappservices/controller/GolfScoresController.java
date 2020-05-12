package com.pjblat.golfscoresappservices.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pjblat.golfscoresappservices.dao.CourseDaoService;
import com.pjblat.golfscoresappservices.dao.GolferDaoService;
import com.pjblat.golfscoresappservices.dao.HoleRepository;
import com.pjblat.golfscoresappservices.dao.HoleYardageRepository;
import com.pjblat.golfscoresappservices.dao.TeeSetRepository;
import com.pjblat.golfscoresappservices.domain.Course;
import com.pjblat.golfscoresappservices.domain.Golfer;
import com.pjblat.golfscoresappservices.domain.Hole;
import com.pjblat.golfscoresappservices.domain.HoleYardage;
import com.pjblat.golfscoresappservices.domain.TeeSet;
import com.pjblat.golfscoresappservices.exception.CourseNotFoundException;
import com.pjblat.golfscoresappservices.exception.GolferNotFoundException;

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
 * - GET /courses/{id}/holes
 *   - retrieve a list of all the holes for a particular course
 * 
 * - GET /courses/{id}/tee-sets
 *   - retrieve a list of all the Tee Sets for a particular course
 *   
 * - GET /courses/{id}/tee-sets/{ts-id}
 *   - retrieve a list of all the Hole Yardages for Tee Sets for a particular course
 * 
 * - GET /courses/{id}/tee-sets-name/{ts-name}
 *   - retrieve a list of all the Hole Yardages for Tee Sets for a particular course
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
	
	@Autowired
	private GolferDaoService golferService;
	
	@Autowired
	private TeeSetRepository teeSetRepository;
	
	@Autowired
	private HoleYardageRepository holeYardageRepository;

	@Autowired
	private HoleRepository holeRepository;

	@GetMapping("/courses")
	public CollectionModel<EntityModel<Course>> retrieveAllCourses()
	{
		List<Course> courses = service.findAll();

		// New School way to build the List of Entity Models using streams and a lambda
		// function.
		// Sample from https://spring.io/guides/tutorials/rest/
		List<EntityModel<Course>> emCourses = courses.stream()
				.map(course -> new EntityModel<>(course,
						linkTo(methodOn(GolfScoresController.class).retrieveCourse(course.getId())).withSelfRel(),
						linkTo(methodOn(GolfScoresController.class).retrieveAllCourses()).withRel("courses")))
				.collect(Collectors.toList());

		return new CollectionModel<>(emCourses,
				linkTo(methodOn(GolfScoresController.class).retrieveAllCourses()).withSelfRel());
	}

	@GetMapping("/courses/{id}")
	public EntityModel<Course> retrieveCourse(@PathVariable int id)
	{
		Course c = service.findOne(id);
		if (c == null)
		{
			throw new CourseNotFoundException("id-" + id);
		}

		// hateoas
		// add links to the current object and /retrieveCourse method
		// Sample from https://spring.io/guides/tutorials/rest/
		return new EntityModel<>(c, linkTo(methodOn(GolfScoresController.class).retrieveCourse(id)).withSelfRel(),
				linkTo(methodOn(GolfScoresController.class).retrieveAllCourses()).withRel("courses"));
	}

	@GetMapping("/courses/{courseId}/holes")
	public CollectionModel<EntityModel<Hole>> retrieveHolesForCourse(@PathVariable int courseId)
	{
		List<Hole> holes = holeRepository.findByCourseId(courseId);
		if (holes == null || holes.size() == 0)
		{
			throw new CourseNotFoundException("course id-" + courseId);
		}

		List<EntityModel<Hole>> emHoles = holes.stream().map(hole -> new EntityModel<>(hole))
				.collect(Collectors.toList());

		return new CollectionModel<>(emHoles,
				linkTo(methodOn(GolfScoresController.class).retrieveHolesForCourse(courseId)).withSelfRel(),
				linkTo(methodOn(GolfScoresController.class).retrieveCourse(courseId)).withRel("holes"));
	}
	
	@GetMapping("/courses/{courseId}/tee-sets")
	public CollectionModel<EntityModel<TeeSet>> retrieveTeeSetsForCourse(@PathVariable int courseId)
	{
		List<TeeSet> teeSets = teeSetRepository.findByCourseId(courseId);
		if (teeSets == null || teeSets.size() == 0)
		{
			throw new CourseNotFoundException("course id-" + courseId);
		}

		List<EntityModel<TeeSet>> emTeeSets = teeSets.stream().map(ts -> new EntityModel<>(ts))
				.collect(Collectors.toList());

		return new CollectionModel<>(emTeeSets,
				linkTo(methodOn(GolfScoresController.class).retrieveTeeSetsForCourse(courseId)).withSelfRel(),
				linkTo(methodOn(GolfScoresController.class).retrieveCourse(courseId)).withRel("course"));
	}
	
	@GetMapping("/courses/{courseId}/tee-sets/{teeSetId}")
	public CollectionModel<EntityModel<HoleYardage>> retrieveHoleYardagesForCourseAndTeeSet(@PathVariable int courseId, @PathVariable int teeSetId)
	{
		List<HoleYardage> holeYardages = holeYardageRepository.findByTeeSetId(teeSetId);
		if (holeYardages == null || holeYardages.size() == 0)
		{
			throw new CourseNotFoundException("course id-" + courseId);
		}

		List<EntityModel<HoleYardage>> emHoleYardages = holeYardages.stream().map(hy -> new EntityModel<>(hy))
				.collect(Collectors.toList());

		return new CollectionModel<>(emHoleYardages,
				linkTo(methodOn(GolfScoresController.class).retrieveHoleYardagesForCourseAndTeeSet(courseId, teeSetId)).withSelfRel(),
				linkTo(methodOn(GolfScoresController.class).retrieveCourse(courseId)).withRel("course"));
	}
	
	@GetMapping("/courses/{courseId}/tee-sets-name/{teeSetName}")
	public CollectionModel<EntityModel<HoleYardage>> retrieveHoleYardagesForCourseAndTeeSetName(@PathVariable int courseId, @PathVariable String teeSetName)
	{
		List<HoleYardage> holeYardages = holeYardageRepository.findByCourseIdAndTeeSetName(courseId, teeSetName);
		if (holeYardages == null || holeYardages.size() == 0)
		{
			throw new CourseNotFoundException("course id-" + courseId);
		}

		List<EntityModel<HoleYardage>> emHoleYardages = holeYardages.stream().map(hy -> new EntityModel<>(hy))
				.collect(Collectors.toList());

		return new CollectionModel<>(emHoleYardages,
				linkTo(methodOn(GolfScoresController.class).retrieveHoleYardagesForCourseAndTeeSetName(courseId, teeSetName)).withSelfRel(),
				linkTo(methodOn(GolfScoresController.class).retrieveHolesForCourse(courseId)).withRel("holes for course"),
				linkTo(methodOn(GolfScoresController.class).retrieveCourse(courseId)).withRel("course"));
	}

	@GetMapping("/golfers")
	public CollectionModel<EntityModel<Golfer>> retrieveAllGolfers()
	{
		List<Golfer> golfers = golferService.findAll();

		// New School way to build the List of Entity Models using streams and a lambda
		// function.
		// Sample from https://spring.io/guides/tutorials/rest/
		List<EntityModel<Golfer>> emGolfers = golfers.stream()
				.map(golfer -> new EntityModel<>(golfer,
						linkTo(methodOn(GolfScoresController.class).retrieveGolfer(golfer.getId())).withSelfRel(),
						linkTo(methodOn(GolfScoresController.class).retrieveAllGolfers()).withRel("golfers")))
				.collect(Collectors.toList());

		return new CollectionModel<>(emGolfers,
				linkTo(methodOn(GolfScoresController.class).retrieveAllGolfers()).withSelfRel());
	}
	
	@GetMapping("/golfers/{id}")
	public EntityModel<Golfer> retrieveGolfer(@PathVariable int id)
	{
		Golfer g = golferService.findOne(id);
		if (g == null)
		{
			throw new GolferNotFoundException("id-" + id);
		}

		// hateoas
		// add links to the current object and /retrieveAllUsers method
		// Sample from https://spring.io/guides/tutorials/rest/
		return new EntityModel<>(g, linkTo(methodOn(GolfScoresController.class).retrieveGolfer(id)).withSelfRel(),
				linkTo(methodOn(GolfScoresController.class).retrieveAllGolfers()).withRel("golfers"));
	}
}
