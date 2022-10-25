package com.te.ramayana.Dto;


import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Herosdto {
	
	@Id
    private int id;
	private String name;
	private String power;
	private String designation;
	private String kingdom;
	private String gender;

	
}
