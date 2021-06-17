package com.centreFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.centreFormat.models.Gestionnaires;
import com.centreFormat.models.Statuts;
import com.centreFormat.repository.GestionnairesRepository;
import com.centreFormat.repository.StatutRepository;

// CentreFormationApplication.class
@SpringBootTest
class CentreFormationApplicationTests {
	
	@Autowired
	StatutRepository SR;
	
	@Autowired
	GestionnairesRepository GR;
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void addNewStatuts() {
		
	}
	
	

}
