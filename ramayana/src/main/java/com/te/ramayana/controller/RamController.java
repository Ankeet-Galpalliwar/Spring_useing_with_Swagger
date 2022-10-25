package com.te.ramayana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.ramayana.Dto.Herosdto;
import com.te.ramayana.entity.Heros;
import com.te.ramayana.reponce.HeroResponce;
import com.te.ramayana.service.HerosService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController

//@RequestMapping("/hero")
public class RamController {
	
	
	@Autowired
	HerosService heroservice;

	@PostMapping(value = "/insert")
	public ResponseEntity<HeroResponce> save(@RequestBody Herosdto herosdto) {
		 Heros saveData = heroservice.saveData(herosdto);
		 return new ResponseEntity<>(new HeroResponce(false, "Hero added Sucessfully", saveData), HttpStatus.OK);
	}	

	
	@GetMapping("/test")
	public ResponseEntity<?> name(@RequestParam String s) {
		return new ResponseEntity<String>(s,HttpStatus.OK);
	}

	@GetMapping("/fetchbyname")
	public List<Heros>  getByName(@RequestParam String name) {
		return heroservice.byName(name);
		
	}
	                                
	@RequestMapping("/findall")
	public List<Heros> findalldata() {
		return heroservice.FindAll();
	} 
	
}

