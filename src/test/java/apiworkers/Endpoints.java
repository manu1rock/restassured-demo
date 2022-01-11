package apiworkers;

public class Endpoints {
	private static final String API = "/api";
	
	public static String users() {
		return API + "/users";
	}
	
	public static String listUsers() {
		return API + "/users?page=2";
	}
}
