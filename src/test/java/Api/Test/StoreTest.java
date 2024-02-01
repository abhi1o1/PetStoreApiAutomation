package Api.Test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import Api.Payload.Store;
import Api.endpoints.StoreEndpoints;
import io.restassured.response.Response;

public class StoreTest {

	Faker faker;

	Store storePayload;

	@BeforeClass
	public void setUpData() {

		faker = new Faker();
		storePayload = new Store();
		
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.idNumber().hashCode());
		

	}
	
	
	@Test(priority=1)
	public void testPostStore() {
		
	Response res = StoreEndpoints.CreateStore(storePayload);
	
	res.then().log().all();
	
	AssertJUnit.assertEquals(res.statusCode(), 200);
		
	}

}
