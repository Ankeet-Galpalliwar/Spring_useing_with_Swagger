package com.te.ramayana.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.ramayana.entity.Heros;

public interface HeroRepo extends JpaRepository<Heros,Integer>{

	List<Heros> findByName(String Name);
	
	  List<Heros> findByGender(String Gender);
	  
	  
}

