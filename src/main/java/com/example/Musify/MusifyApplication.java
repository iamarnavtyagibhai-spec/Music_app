package com.example.Musify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusifyApplication {

	public static void main(String[] args) {
		// SpringApplication.run(MusifyApplication.class, args);
		 System.out.println("MONGODB_URI=" + System.getenv("MONGODB_URI"));
        System.out.println("GOOGLE_CLIENT_ID=" + System.getenv("GOOGLE_CLIENT_ID"));
        System.out.println("GOOGLE_CLIENT_SECRET=" + System.getenv("GOOGLE_CLIENT_SECRET"));
        SpringApplication.run(MusifyApplication.class, args);
	}

}
