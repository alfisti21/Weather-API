package com.example.demo2;

import java.io.IOException;
import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.jayway.jsonpath.JsonPath;

//a90c287b3601d501cb03960283bb91a2 Weather API Key

@RestController
public class AdviceRestController {
	
	private final TemperaturesRepository repository;

	AdviceRestController(TemperaturesRepository repository) {
		this.repository = repository;
	}

    @GetMapping(path="/advice/{city}")
    public Map<String, String> getMessage(@PathVariable("city") String city) throws JsonParseException, JsonMappingException, IOException {
    	
    	final String uri = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&APPID=a90c287b3601d501cb03960283bb91a2";
    	final String uri2 = "http://localhost:8080/temperatures";
    	HashMap<String, String> map = new HashMap<>();

        RestTemplate restTemplate = new RestTemplate();
        RestTemplate restTemplate2 = new RestTemplate();
        String result1 = restTemplate.getForObject(uri, String.class);
        String result2 = restTemplate.getForObject(uri2, String.class); 
        Double s = JsonPath.read(result1, "$.main.temp");
        List<Integer> s1 = JsonPath.read(result2, "$..minTemp");
        int s2 = s1.size();
        
        
        //int length = s2.length();
        //for (int i=0)
        System.out.println(s2);
        System.out.println(s1.get(0));
        Integer a = (int) Math.round(s);
        String temperature = Integer.toString(a-273);         
        
        map.put("city", city);
        map.put("currentTemperature", temperature);        
        //map.put("advice", s2);        
        return map;  	        
    }
}