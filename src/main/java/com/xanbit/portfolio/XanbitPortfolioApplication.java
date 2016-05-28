package com.xanbit.portfolio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class XanbitPortfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(XanbitPortfolioApplication.class, args);
	}
}

@RestController
class HomeController {
    
    @RequestMapping("/info")
    public Map<String,Object> home() {
      Map<String,Object> model = new HashMap<String,Object>();
      model.put("id", UUID.randomUUID().toString());
      model.put("content", "Under Construction....");
      Date launchDate = getLaunchDate();
      model.put("launchdate", launchDate != null ? launchDate : new Date());
      return model;
    }
    
    private Date getLaunchDate(){

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        isoFormat.setTimeZone(TimeZone.getTimeZone("CET"));
        
        try {
			Date date = isoFormat.parse("2016-06-06T09:00:00");
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return null;
    }
}


