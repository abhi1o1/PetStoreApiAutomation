package Api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import Api.Payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class StoreEndpoints {

	public static Response CreateStore(Store Payload) {

		Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(Payload).when().post(Routes.store_Post_url);

		return res;

	}

	public static Response getUser(String OrderId) {

		Response res = given().relaxedHTTPSValidation().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParams("1", OrderId)

				.when().get(Routes.store_Get_Url);

		return res;

	}

}
