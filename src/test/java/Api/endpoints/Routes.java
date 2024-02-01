package Api.endpoints;


/* 
 Swagger User -->  https://petstore.swagger.io
 
 Create User (Post) :   https://petstore.swagger.io/v2/user
 Get User (Get): https://petstore.swagger.io/v2/user/{username}
 update User (Put):  https://petstore.swagger.io/v2/user/{username}
 delete User (Delete): https://petstore.swagger.io/v2/user/{username}
 */
public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	public static String post_url = base_url+"/user";
	
	public static String get_url = base_url+"/user/{username}";
	
	public static String update_url = base_url+"/user/{username}";
	
	public static String delete_url = base_url+"/user/{username}";
	
	public static String store_Post_url = base_url+"/store/order";
	
	public static String store_Get_Url = base_url+"/store/order/{orderId}";
	
	public static String Store_Delete_Url = base_url+"/store/order/{orderId}";
	

}
