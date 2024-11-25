package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import ap.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.response.Response;

public class UsersTests {
	
	
	Faker faker;
	User userpayload;
	public Logger logger;
	
	
	@BeforeClass
	public void setupData()
	{
		faker= new Faker();
		userpayload= new User();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setUserStatus(0);
		
		//logs
		logger= LogManager.getLogger(this.getClass());
		
	}
	
	@Test (priority = 1)
	public void testPostUser()
	{
		
		logger.info("*************Creating user******************");
		Response response=UserEndpoints.createUser(userpayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************User is created******************");
	}
	
	
	
	
	@Test(priority = 2)
	
	public void testGetUserbyName()
	{
		
		logger.info("*************Reading user******************");
		Response response= UserEndpoints.readUser(this.userpayload.getUsername());
		
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("*************User info is read******************");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
