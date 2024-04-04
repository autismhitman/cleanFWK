package com.neopane.utils;

import static io.restassured.RestAssured.given;

 
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public final class ElkUtils {
	
	
	private ElkUtils() {}
	
	public static void getElkDocs(String testCaseName, String status) {
		
		Map<String, String> hmap = new HashMap<>();
		hmap.put("TestCaseName", testCaseName);
		hmap.put("Status", status);
		hmap.put("ExecutionTime", LocalDateTime.now().toString());
		
		given()
		.header("Content-Type","application/json") 
		.body(hmap)
		.post("")
		.then()
		.statusCode(201);
		
	}

}
