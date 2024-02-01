package Api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import Api.Payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

// userendpoints.java
//created for to perform curd operation
public class UserEndpoints {

	public static Response createUser(User Payload) {

		Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(Payload).when().post(Routes.post_url);

		return res;

	}

	public static Response getUser(String userName) {

		Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName)

				.when().get(Routes.get_url);

		return res;
	}

	public static Response updateUser(String userName, User Payload) {

		Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", userName).body(Payload).when().put(Routes.update_url);

		return res;
	}

	public static Response DeleteUser(String userName) {

		Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
				      .pathParam("username", userName)

				.when().delete(Routes.delete_url);

		return res;
	}

}