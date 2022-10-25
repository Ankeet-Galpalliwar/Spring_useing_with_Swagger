package com.te.ramayana.service;

import java.util.List;

import com.te.ramayana.Dto.Herosdto;
import com.te.ramayana.entity.Heros;

public interface HerosService {
	
	public Heros saveData(Herosdto herosdto);
	
	public List<Heros> byName(String heroName);
	
	public List<Heros> byGender(String heroGender);
	
	public  List<Heros> FindAll();
	

}
