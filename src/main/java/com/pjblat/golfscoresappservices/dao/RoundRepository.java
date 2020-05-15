package com.pjblat.golfscoresappservices.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pjblat.golfscoresappservices.domain.Hole;
import com.pjblat.golfscoresappservices.domain.Round;
import com.pjblat.golfscoresappservices.domain.TeeSet;

public interface RoundRepository extends JpaRepository<Round, Integer>
{

}
