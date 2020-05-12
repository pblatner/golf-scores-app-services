package com.pjblat.golfscoresappservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pjblat.golfscoresappservices.domain.Hole;

public interface HoleRepository extends JpaRepository<Hole, Integer>
{
	List<Hole> findByCourseId(Integer courseId);
}
