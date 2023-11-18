package Assessment3;

import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonArray;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonObject;
import io.cucumber.cienvironment.internal.com.eclipsesource.json.JsonValue;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.remote.JsonToWebElementConverter;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Function;
import com.google.gson.JsonElement;

import groovy.lang.Singleton;


public class assessment3 {
	public ArrayList<String> list;
	public ArrayList<String> list1;
	public int j;
	//public String[] stringArray;
	//public int i=1;
	
	@Test
	
	public void getFoodNames() throws ParseException {
		baseURI = "https://coinmap.org";
		Response res = given().
		contentType(ContentType.JSON).
		when().
		get("/api/v1/venues/").
		then().
		statusCode(200).
		extract().response();

	    String response =  res.getBody().asString();
	    JSONParser jp = new JSONParser();
	    JSONObject jobj = (JSONObject)jp.parse(response);
	    System.out.println("Desired JSON Format is: " + jobj);
	   // stringArray = new String[i];
	    list = new ArrayList<String>();
	    list1 = new ArrayList<String>();
	    JsonPath path = JsonPath.from(response);
	    List<HashMap<String, Object>> jsonObjects = path.getList("venues");
			for (HashMap<String, Object> singleJsonObject : jsonObjects) {
	    		String category = (String) singleJsonObject.get("category");
	    		list.add(category);      
	    		if (category.equals("food")) {
	    			System.out.println(singleJsonObject.get("geolocation_degrees"));
            }
			}
			System.out.println(list.size());
			int dupCount = 0;		    
		    String venue[] = list.toArray(new String[list.size()]);
		      Map<String, Integer> venues1 = new HashMap<>();
		      
		        // Count the frequency of each string in arr
		        for (String str : venue) {
		            venues1.put(str, venues1.getOrDefault(str, 0) + 1);
		        }
		 
		        // Print unique strings in arr
		        for (Map.Entry<String, Integer> entry : venues1.entrySet()) {
		            if (entry.getValue() == 1) {
		                System.out.print(entry.getKey() + " ,");
		                
		                list1.add(entry.getKey());
		            }else {
		            	System.out.print(entry.getKey() + " ,");
		            	list1.add(entry.getKey());
		            }
		        }		        
		    for(int i = 0; i < list1.size(); i++){
		        for(int j = 1; j < list.size(); j++){
		            if(list1.get(i).equals(list.get(j))){
		              //  if(!venues.contains(venue[j])){
		                  //start 
		            	dupCount++;
		              //   venues.add(venue[j]);
		            	//System.out.println(list.get(j));
		                }
		            }
		        System.out.println("duplicate count is: " + list1.get(i) +":"+ dupCount);
		        dupCount=0;
		        } 
}

}
