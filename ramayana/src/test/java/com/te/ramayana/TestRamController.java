package com.te.ramayana;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
//post get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//status
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.annotation.Before;
//import org.junit.runner.Runwith;
import org.junit.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.ramayana.Dto.Herosdto;
import com.te.ramayana.controller.RamController;
import com.te.ramayana.dao.HeroRepo;
import com.te.ramayana.entity.Heros;
import com.te.ramayana.service.serviceimpl.HerosServiceImpl;

import net.bytebuddy.agent.VirtualMachine.ForHotSpot.Connection.Response;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class TestRamController {
	@Mock
	HeroRepo refHeroRepo;

	@Autowired
	WebApplicationContext contex;

	@Mock
	RamController ramController;

	@Mock
	HerosServiceImpl herosServiceImpl;

	@InjectMocks
	Heros obj;

	@Autowired
	private MockMvc mockmvc;

	@Before(value = "")
	public void setup() {
		mockmvc = MockMvcBuilders.webAppContextSetup(contex).build();
	}

	Heros entry1 = new Heros(11, "nam8", "power1", "designatation1", "kingdom1", "gender1");
	Heros entry2 = new Heros(12, "nam3", "power2", "designatation2", "kingdom2", "gender2");
	Heros entry3 = new Heros(13, "nam4", "power3", "designatation3", "kingdom3", "gender3");

	//Repo test
	@Test
	public void findall() {
		java.util.List<Heros> list = Arrays.asList(entry1, entry2);
		Mockito.when(refHeroRepo.findAll()).thenReturn(list);
		List<Heros> findAll = refHeroRepo.findAll();
		System.out.println(findAll.size());
		assertEquals(findAll.size(), list.size());
	}

	
	@Test
	public void findByName() {
		List<Heros> getlist = Arrays.asList(entry1, entry2, entry3);
		Mockito.when(refHeroRepo.findByName(Mockito.anyString())).thenReturn(getlist);
		List<Heros> findByName = refHeroRepo.findByName("nam1");
		assertEquals(findByName.get(0).getName(), getlist.get(0).getName());
	}

	
	@Test
	public void testfindByGender() {
		List<Heros> getlist = Arrays.asList(entry1, entry2, entry3);
		Mockito.when(refHeroRepo.findByGender(Mockito.anyString())).thenReturn(getlist);
		List<Heros> findByGender = refHeroRepo.findByGender("oo");
		assertEquals(getlist.get(0).getGender(), findByGender.get(0).getGender());
	}
	
	

	// Implementation Test
//	@Test
//	public Heros ImplSavedata() {
//		Heros data = new Heros(12, "nam3", "power2", "designatation2", "kingdom2", "gender2");
//		Mockito.when(herosServiceImpl.saveData(Mockito.any())).thenReturn(data);
//		refHeroRepo.s
////		assertEquals(obj1,ramController.save(obj1) );
//	}

//	@Test
//	public void conSerarchbyname() {
//		List<Heros>storlist=Arrays.asList(entry1, entry2, entry3); //DataBase List
//		List<Heros> byName = ramController.getByName(Mockito.anyString());
//		
//		List<Heros>newlist=new ArrayList<Heros>();
//		for(int i=0;i<storlist.size();i++) {
//			for(int j=0;i<newlist.size();j++) {
//			if(storlist.get(i).getName().equals(byName.get(j).getName())){
//				newlist.add(storlist.get(i));
//			 }
//		  }
//		}
//		assertEquals(byName, newlist);
//	}

	
//	@Test
//	public void confindall() {
//		List<Heros>getlist=Arrays.asList(entry1, entry2, entry3);
//	
//		Mockito.when(ramController.findalldata()).thenReturn(getlist);
//		List<Heros> findalldata = (ramController.findalldata());
//     	assertEquals(findalldata.size(), 3);
//
//		
//	}

//=======================================
	// when(herosServiceImpl.saveData(entry1)).thenReturn(entry1);
//	ObjectMapper mapper=new ObjectMapper();
//	String writeValueAsString = mapper.writeValueAsString(entry1);
//	this.mockmvc.perform(null)).Contains()
//=============================================

	@Test
	public void coninseart() throws Exception {
		Heros heros = new Heros(11, "nam1", "power1", "designatation1", "kingdom1", "gender1");
		ObjectMapper objectMapper = new ObjectMapper();
		String AsString = objectMapper.writeValueAsString(heros);

		 mockmvc.perform((post("/insert").content(AsString).contentType(MediaType.APPLICATION_JSON_VALUE)))
				.andExpect(status().isOk());
		 
//		String contentAsString = result.getResponse().getContentAsString();
//		@SuppressWarnings("rawtypes")
//		ResponseEntity readValue = objectMapper.readValue(contentAsString, ResponseEntity.class);
//		// getvalue.isstatus()==Boolean.TRUE
//		Assert.assertTrue(readValue.getBody() == Boolean.TRUE);
	}

	
	
	@Test
	public void congetalldata() throws Exception {
		
		mockmvc.perform((get("/findall").contentType(MediaType.APPLICATION_JSON_VALUE)))
		.andExpect(status().isOk()).andReturn();

//		MvcResult result = mockmvc.perform((get("/findall").contentType(MediaType.APPLICATION_JSON_VALUE)))
//				.andExpect(status().isOk()).andReturn();
//		String contentAsString = result.getResponse().getContentAsString();
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		 org.apache.catalina.connector.Response readValue = objectMapper.readValue(result,org.apache.catalina.connector.Response.class);
//
//		Assert.assertTrue(!readValue.isError());
	}

	@Test
	public void congetbyname() throws Exception {
			Heros heros = new Heros(11, "csmaker", "power1", "designatation1", "kingdom1", "gender1");
			ObjectMapper objectMapper=new ObjectMapper();
			String DataAsString = objectMapper.writeValueAsString(heros.getName());
	    	String valuepass = "csmaker";
	    	 String ValueAsString = objectMapper.writeValueAsString(valuepass);

		this.mockmvc.perform((get("/fetchbyname").content(ValueAsString).contentType(MediaType.APPLICATION_JSON_VALUE)))
				.andExpect(status().isOk()).andReturn();
	}
	
	
	
//	//dto
//	@Test
//	public void dtoinsert() {
//		Heros heros = new Heros(11, "csmaker", "power1", "designatation1", "kingdom1", "gender1");
//		Herosdto herosdto=new Herosdto(11, "csmaker", "power1", "designatation1", "kingdom1", "gender1");
//		when(refHeroRepo.save(Mockito.any())).thenReturn(heros);
//		assertEquals(herosServiceImpl.saveData(herosdto), heros);
//	}
//	@Test
//	public void dtofindbyname() {
//		List<Heros> heros = Arrays.asList(new Heros(11, "csmaker", "power1", "designatation1", "kingdom1", "gender1"));
//		when(refHeroRepo.findByName(Mockito.anyString())).thenReturn(heros);
//		assertEquals(herosServiceImpl.byName(null), heros);
//	}
	

}
