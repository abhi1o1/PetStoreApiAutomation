package Api.Test;

import org.testng.annotations.Test;
import Api.Payload.User;
import Api.Utilites.DataProviders;
import Api.endpoints.UserEndpoints;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DDUserTest {

	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void PostUserTest(String UserId, String UserName, String fname, String lname, String useremail, String pwd,
			String ph) {

		User UserPayload = new User();

		UserPayload.setId(Integer.parseInt(UserId));
		UserPayload.setUsername(UserName);
		UserPayload.setFirstName(fname);
		UserPayload.setLastName(lname);
		UserPayload.setEmail(useremail);
		UserPayload.setPassword(pwd);
		UserPayload.setPhone(ph);

		Response Res = UserEndpoints.createUser(UserPayload);

		// Res.then().log().all();

		Assert.assertEquals(Res.getStatusCode(), 200);

	}

	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void GetUserTest(String UserName) {

		Response res = UserEndpoints.getUser(UserName);

		Assert.assertEquals(res.statusCode(), 200);

		System.out.println(res);
	}

	@Test(priority = 3, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void DeleteUser(String UserName) {

		Response res = UserEndpoints.DeleteUser(UserName);

		Assert.assertEquals(res.getStatusCode(), 200);

	}

}
