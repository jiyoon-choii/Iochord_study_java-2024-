package io.iochord.demo;

import io.iochord.demo.model.Activitycode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		/*
		Activitycode activitycode = new Activitycode();
		activitycode.setActivitycode("B001");
		 */
		//activitycode.activitycode = "B002";

		SpringApplication.run(DemoApplication.class, args);
	}

}
