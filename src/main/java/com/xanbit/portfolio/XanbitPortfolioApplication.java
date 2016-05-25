package com.xanbit.portfolio;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
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
      model.put("launchdate", new Date());
      return model;
    }
}


