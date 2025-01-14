package com.lacktrack.lack_track;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
public class LackTrackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LackTrackApplication.class, args);
	}

}
