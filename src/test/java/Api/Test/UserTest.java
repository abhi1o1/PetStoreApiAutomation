package Api.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.github.javafaker.Faker;

import Api.Payload.User;
import Api.endpoints.UserEndpoints;

import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTest {

	Faker faker;

	User userPayload;
	
	Logger Logger;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();
		userPayload = new User();
		
		

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUsername(faker.name().username());
		
		Logger =  LogManager.getLogger(this.getClass());

	}

	@Test(priority = 1)
	public void testPostUser() {
		
		Logger.info("*****Creating User********");

		Response response = UserEndpoints.createUser(userPayload);

		response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		Logger.info("*****Created User********");

	}

	@Test(priority = 2)
	public void testGetUser() {
		
		Logger.info("*****Retreving User********");

		Response response = UserEndpoints.getUser(this.userPayload.getUsername());

		response.then().log().all();

		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		Logger.info("******Done********");
	}

	@Test(priority = 3)
	public void testUpdateUser() {
		
		Logger.info("******Updating User********");
		// updated Data
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		
		System.out.println(userPayload.toString());

		Response response = UserEndpoints.updateUser(this.userPayload.getUsername(), userPayload);

		response.then().log().body().statusCode(200);
		
		Logger.info("******Updated User********"); 

		

		// checking data after updation

		Response responseAfterUpdation = UserEndpoints.getUser(this.userPayload.getUsername());

		Assert.assertEquals(responseAfterUpdation.getStatusCode(), 200);
		Logger.info("******Retreive Updated  User********"); 
		
		

	}
	
	@Test(priority = 4)
	public void testdeleteUser() {
		
		Logger.info("******Deleting User********"); 
		
		Response res = UserEndpoints.DeleteUser(this.userPayload.getUsername());
		
		res.then().log().body().statusCode(200);
		
		Logger.info("******Deleted User********");  
		
	}
	
	
	
}
