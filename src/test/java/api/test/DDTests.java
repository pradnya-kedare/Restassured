package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ap.endpoints.UserEndpoints;
import api.payloads.User;
import io.restassured.response.Response;

import api.utilities.DataProviders;

public class DDTests {

	
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userID,String userName,String fname ,String lname,String useremail,String pwd,String ph)
	
	{
		User userpayload= new User();
		
	//	userpayload.setId(Integer.parseInt(userID));
		
		userpayload.setId((int) Double.parseDouble(userID));
		userpayload.setUsername(userName);
		userpayload.setFirstName(fname);
		userpayload.setLastName(lname);
		userpayload.setEmail(useremail);
		userpayload.setPassword(pwd);
		userpayload.setPhone(ph);

		Response response=UserEndpoints.createUser(userpayload);
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserbyName(String userName)
	
	
	{
		
		
		Response response= UserEndpoints.deleteUser(userName);
		
		
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	
}
