package com.pjblat.golfscoresappservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pjblat.golfscoresappservices.domain.Hole;
import com.pjblat.golfscoresappservices.domain.HoleYardage;
import com.pjblat.golfscoresappservices.domain.TeeSet;

public interface HoleYardageRepository extends JpaRepository<HoleYardage, Integer>
{
	List<HoleYardage> findByTeeSetId(Integer teeSetId);
	
	@Query("select hy from HoleYardage hy where hy.teeSet.course.id = ?1 and hy.teeSet.name = ?2")
	List<HoleYardage> findByCourseIdAndTeeSetName(Integer courseId, String teeSetName);
}
