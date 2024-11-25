package ap.endpoints;


//createuser:  https://petstore.swagger.io/v2/user/
//getuser:     https://petstore.swagger.io/v2/user/{username}
//put:         https://petstore.swagger.io/v2/user/{username}
//delete:      https://petstore.swagger.io/v2/user/{username}









public class Routes {

	
	public static String base_url= "https://petstore.swagger.io/#/";
	
	//user model
	
	public static String post_url="https://petstore.swagger.io/v2/user";
	public static String get_url= base_url+"user/{username}";
	public static String update_url= base_url+"user/{username}";
	public static String delete_url="https://petstore.swagger.io/v2/user/{username}";
	
	
	
	
}
