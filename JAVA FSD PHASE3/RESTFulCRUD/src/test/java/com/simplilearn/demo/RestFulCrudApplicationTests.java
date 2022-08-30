package com.simplilearn.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestFulCrudApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private UserService service;
	//create record
	@Disabled
	@Test
	public void addTest()
	{
		Assertions.assertNotNull(service.addUser(new User("kamali","kamali@gmail.com","India")));
	}
	 //get all
    
    @Test
    public void getAllTest() {
             Assertions.assertEquals(3,service.getAllUser().size());
             
    }
	
    //get by id
    @Disabled
	@Test
	public void getByIDTest() {
        Assertions.assertEquals("sarvesh",service.getUserById(2).getName());
}
	
	//deletebyid
	@Disabled
	@Test
	public void deleteByIDTest()
	{
		Assertions.assertNotNull(service.deleteUser(2));
	}
	
	//updatebyid
	@Disabled
	 @Test
	    public void UpdateByIDTest() {
	             Assertions.assertNotNull(service.updateUser(new User("prashanthsundar","prashanth@yahoo.com","INDIA"), 1));
	             
	    }
}
