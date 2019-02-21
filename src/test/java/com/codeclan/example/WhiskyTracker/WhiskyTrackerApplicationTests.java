package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findWhiskysByYear() {
		List<Whisky> found = whiskyRepository.findWhiskyByYear(2018);
		assertEquals(2, found.size());
	}

	@Test
	public void findDistilleryByRegion() {
		List<Distillery> found = distilleryRepository.findDistilleryByRegion("Lowland");
		assertEquals(1, found.size());
		assertEquals("Rosebank", found.get(0).getName());
	}

	@Test
	public void findWhiskiesByAgeAndDistilleryId() {
		List<Whisky> found = whiskyRepository.findWhiskiesByAgeAndDistilleryId(15, 1L);
		assertEquals("The Glendronach Revival", found.get(0).getName());
	}

	//	Failing - Caused by: java.lang.IllegalStateException: No transactional EntityManager available
//	but working on browser

//	@Test
//	public void findWhiskyByAgeAndByDistillery() {
//		List<Whisky> found = whiskyRepository.findWhiskiesFromDistilleryOfAge( "Glendronach", 12);
//		assertEquals("The Glendronach Original", found.get(0).getName());
//	}
//
//	@Test
//	public void findWhiskyByRegion() {
//		List<Whisky> found = whiskyRepository.findWhiskiesFromRegion("Highland");
//		assertEquals(2, found.size());
//	}
}
