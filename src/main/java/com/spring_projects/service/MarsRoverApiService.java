package com.spring_projects.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.spring_projects.responsse.MarsRoverApiResponse;

@Service
public class MarsRoverApiService {
     
	private static final String API_KEY = "sa984rD5Vw674ei7fQBYm9QyXxVuhwflXShtsyJN";
	
	public  MarsRoverApiResponse getRoverData(String roverType) {
       RestTemplate rt = new RestTemplate();
		
		ResponseEntity<MarsRoverApiResponse> response = rt.getForEntity("https://api.nasa.gov/mars-photos/api/v1/rovers/"+roverType+"/photos?sol=2&api_key=" + API_KEY, MarsRoverApiResponse.class);
		return response.getBody();
	}
}
