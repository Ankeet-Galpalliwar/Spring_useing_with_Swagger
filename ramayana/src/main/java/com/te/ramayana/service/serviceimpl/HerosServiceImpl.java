package com.te.ramayana.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.te.ramayana.Dto.Herosdto;
import com.te.ramayana.dao.HeroRepo;
import com.te.ramayana.entity.Heros;
import com.te.ramayana.exception.handleEmptyInput;
import com.te.ramayana.service.HerosService;

@Service

public class HerosServiceImpl implements HerosService {

	@Autowired
	private HeroRepo heroRepo;

	

	@Autowired
	Herosdto herosdto;

	
	@Override
	public Heros saveData(Herosdto herosdto) {
		// herosdto=null;
		if (herosdto == null) {
			throw new handleEmptyInput("no data found");
		}
		Heros heros = new Heros();
		BeanUtils.copyProperties(herosdto, heros);
		Heros save = heroRepo.save(heros);
		return save;
	}

	@Override
	public List<Heros> byName(String heroName) {
//		Optional<Heros>findByName=heroRepo.findByName(heroName);
//		if(findByName.isPresent()) {
//			return findByName.get();
//		}
		List<Heros> findByName = heroRepo.findByName(heroName);
		if (findByName.size() != 0) {
//			List<Herosdto>findbyDto=new ArrayList<Herosdto>();
//			BeanUtils.copyProperties(findByName, findbyDto);
//			return findbyDto;
			return findByName;
		}

		throw new handleEmptyInput("no data found by given name");
	}

	@Override
	public List<Heros> byGender(String heroGender) {
		List<Heros> findByGender = heroRepo.findByGender(heroGender);
		if (findByGender != null) {
//			List<Herosdto> findBygenderDto = new ArrayList<Herosdto>();
//			BeanUtils.copyProperties(findByGender, findBygenderDto);
//			System.out.println("================================================" + findBygenderDto);
//			return findBygenderDto;
			return findByGender;

		}
		throw new RuntimeException("no data found by gender");
	}

	@Override
	public List<Heros> FindAll() {
		List<Heros> findAll = heroRepo.findAll();
		if (findAll != null) {
//			List<Herosdto> findallDto = new ArrayList<Herosdto>();
//			BeanUtils.copyProperties(findAll, findallDto);
//			return findallDto;
			return findAll;
		}
		throw new handleEmptyInput("no data found in Table");

	}

}
