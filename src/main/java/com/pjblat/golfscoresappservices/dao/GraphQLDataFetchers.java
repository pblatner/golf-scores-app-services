package com.pjblat.golfscoresappservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.pjblat.golfscoresappservices.domain.Course;
import com.pjblat.golfscoresappservices.domain.Hole;
import com.pjblat.golfscoresappservices.domain.HoleScore;
import com.pjblat.golfscoresappservices.domain.HoleYardage;
import com.pjblat.golfscoresappservices.domain.TeeSet;

import graphql.schema.DataFetcher;

@Component
public class GraphQLDataFetchers
{
	/*
	 * used for in memory testing of the services prior to DB implementation private
	private static List<Course> courses = new ArrayList<>();
	private static int coursesCount = 2;
	*/

	/*
	 * used for in memory testing of the services prior to DB implementation private
	static
	{
		Course tf = new Course(1, "Tanna Farms");

		List<HoleYardage> c1h1yardages = new ArrayList<HoleYardage>();
		HoleYardage h1t1 = new HoleYardage(1001, 1, 4, 400);
		HoleYardage h1t2 = new HoleYardage(1002, 1, 4, 380);
		HoleYardage h1t3 = new HoleYardage(1003, 1, 4, 360);
		HoleYardage h1t4 = new HoleYardage(1004, 1, 4, 343);
		c1h1yardages.add(h1t1);
		c1h1yardages.add(h1t2);
		c1h1yardages.add(h1t3);
		c1h1yardages.add(h1t4);

		List<HoleYardage> c1h2yardages = new ArrayList<HoleYardage>();
		HoleYardage h2t1 = new HoleYardage(2001, 2, 3, 182);
		HoleYardage h2t2 = new HoleYardage(2002, 2, 3, 173);
		HoleYardage h2t3 = new HoleYardage(2003, 2, 3, 164);
		HoleYardage h2t4 = new HoleYardage(2004, 2, 3, 123);
		c1h2yardages.add(h2t1);
		c1h2yardages.add(h2t2);
		c1h2yardages.add(h2t3);
		c1h2yardages.add(h2t4);

		List<HoleYardage> c1h3yardages = new ArrayList<HoleYardage>();
		HoleYardage h3t1 = new HoleYardage(3001, 3, 5, 545);
		HoleYardage h3t2 = new HoleYardage(3002, 3, 5, 523);
		HoleYardage h3t3 = new HoleYardage(3003, 3, 5, 490);
		HoleYardage h3t4 = new HoleYardage(3004, 3, 5, 436);
		c1h3yardages.add(h3t1);
		c1h3yardages.add(h3t2);
		c1h3yardages.add(h3t3);
		c1h3yardages.add(h3t4);

		List<TeeSet> c1teeSets = new ArrayList<TeeSet>();
		TeeSet c1ts1 = new TeeSet(1, "Black", 120.5, 73.4);
		c1ts1.setHoleYardages(new ArrayList<HoleYardage>());
		c1ts1.getHoleYardages().add(h1t1);
		c1ts1.getHoleYardages().add(h2t1);
		c1ts1.getHoleYardages().add(h3t1);

		TeeSet c1ts2 = new TeeSet(2, "Blue", 114.0, 71.2);
		c1ts2.setHoleYardages(new ArrayList<HoleYardage>());
		c1ts2.getHoleYardages().add(h1t2);
		c1ts2.getHoleYardages().add(h2t2);
		c1ts2.getHoleYardages().add(h3t2);

		TeeSet c1ts3 = new TeeSet(3, "White", 110.8, 68.6);
		c1ts3.setHoleYardages(new ArrayList<HoleYardage>());
		c1ts3.getHoleYardages().add(h1t3);
		c1ts3.getHoleYardages().add(h2t3);
		c1ts3.getHoleYardages().add(h3t3);

		TeeSet c1ts4 = new TeeSet(3, "Red", 96.0, 65.1);
		c1ts4.setHoleYardages(new ArrayList<HoleYardage>());
		c1ts4.getHoleYardages().add(h1t4);
		c1ts4.getHoleYardages().add(h2t4);
		c1ts4.getHoleYardages().add(h3t4);

		c1teeSets.add(c1ts1);
		c1teeSets.add(c1ts2);
		c1teeSets.add(c1ts3);
		c1teeSets.add(c1ts4);

		List<Hole> c1Holes = new ArrayList<Hole>();
		c1Holes.add(new Hole(1, 1, 3));
		c1Holes.add(new Hole(2, 2, 5));
		c1Holes.add(new Hole(3, 3, 4));

		courses.add(tf);
	}
	

	public DataFetcher<Course> getCourseByIdDataFetcher()
	{
		return dataFetchingEnvironment -> {
			Integer courseId = dataFetchingEnvironment.getArgument("id");
			return courses
					.stream()
					.filter(c -> c.getId().equals(courseId))
					.findFirst()
					.orElse(null);
		};
	}
	*/
	
	/*
	public DataFetcher<List<Hole>> getHolesDataFetcher() {
        return dataFetchingEnvironment -> {
            Course c = dataFetchingEnvironment.getSource();
            List<Hole> holes = c.getHoles();
            return holes;
        };
    }
    */

}
