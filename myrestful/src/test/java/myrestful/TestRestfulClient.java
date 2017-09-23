package myrestful;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestRestfulClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/spittles";
	
	 public static void main(String args[]){
//			listAllUsers();
//			getUser();
			createUser();
//			listAllUsers();
//			updateUser();
//			listAllUsers();
//			deleteUser();
//			listAllUsers();
//			deleteAllUsers();
//			listAllUsers();
	    }
	
	/* GET */
	@SuppressWarnings("unchecked")
	private static void listAllUsers(){
		System.out.println("Testing listAllUsers API-----------");
		
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Spittle>> usersMap = restTemplate.getForObject(REST_SERVICE_URI+"/", List.class);
		
		if(usersMap!=null){
			for(LinkedHashMap<String, Spittle> map : usersMap){
	            System.out.println(map);
	        }
		}else{
			System.out.println("No user exist----------");
		}
	}
	
	/* GET */
	private static void getUser() {
		System.out.println("Testing getUser API----------");
		RestTemplate restTemplate = new RestTemplate();
       
//		Spittle user = restTemplate.getForObject(REST_SERVICE_URI+"/1", Spittle.class);
//        System.out.println(user);
        
        ResponseEntity<Spittle> response = restTemplate.getForEntity(REST_SERVICE_URI + "/{id}", Spittle.class, 1);
        Spittle sp = response.getBody();
        System.out.println(sp);
        
        
        /*Class spCla = sp.getClass();
        Field[] fs1 = spCla.getDeclaredFields();
        System.out.println("Field---------------");
        for (Field f : fs1) {
        	f.setAccessible(true);
        	Object val;
			try {
				val = f.get(sp);
				System.out.println(f.getType() + "-" + f.getName() + "-" + val);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        Method[] ms1 = spCla.getMethods();
        System.out.println("Method---------------");
        for (Method m : ms1) {
        	System.out.print(m.getName() + "-");
        	try {
				System.out.println( "-" + m.invoke(sp, null));
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }*/
        
        /*Class respCla = response.getClass();
        Field[] fs = respCla.getDeclaredFields();
        for (Field f : fs) {
        	f.setAccessible(true);
        	Object val;
			try {
				val = f.get(response);
				System.out.println(f.getType() + "-" + f.getName() + "-" + val);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        Method[] ms = respCla.getMethods();
        for (Method m : ms) {
        	System.out.println(m.getName() + "-" + m.getTypeParameters());
        }*/
        
        
        
        
	}
	
	/* POST */
    private static void createUser() {
		System.out.println("Testing create User API----------");
		
    	RestTemplate restTemplate = new RestTemplate();
//    	Spittle user = new Spittle(1L, "Sarah", new Date(), 30.12, 31.12);
    	Spittle user = new Spittle(2L, "jeky", new Date(), 30.12, 31.12);
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/", user, Spittle.class);
        System.out.println("Location : " + uri.toASCIIString());
        
    }
    
    /* PUT */
    private static void updateUser() {
		System.out.println("Testing update User API----------");
        RestTemplate restTemplate = new RestTemplate();
        Spittle user  = new Spittle(1L, "Luck", new Date(), 30.12, 31.12);
        restTemplate.put(REST_SERVICE_URI+"/1", user);
        System.out.println(user);
    }

    /* DELETE */
    private static void deleteUser() {
		System.out.println("Testing delete User API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/3");
    }


    /* DELETE */
    private static void deleteAllUsers() {
		System.out.println("Testing all delete Users API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/user/");
    }


}
