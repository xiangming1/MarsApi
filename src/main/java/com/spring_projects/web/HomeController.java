package com.spring_projects.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring_projects.responsse.MarsRoverApiResponse;
import com.spring_projects.service.MarsRoverApiService;

@Controller
public class HomeController {
	
	
  @Autowired	
  private MarsRoverApiService roverService;
	
  @GetMapping("/")//get mapping, listen to route
  public String getHomeView (ModelMap model, @RequestParam(required=false) String marsApiRoverData) {
	  
	  //if request param is empty, then set a default value
	  if(StringUtils.isEmpty(marsApiRoverData)) {
		  marsApiRoverData = "opportunity";
	  }
	  MarsRoverApiResponse roverData = roverService.getRoverData("opportunity");  
	  model.put("roverData", roverData);
	  return "index"; //return index.html
	  
  }
  

  
}
