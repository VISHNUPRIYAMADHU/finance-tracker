package com.example.finance_tracker;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceTrackerApplication {

	public static void main(String[] args) {
		 // Load the .env file
		 Dotenv dotenv = Dotenv.load();
        
		 // Print environment variables to verify they are loaded correctly
		 System.out.println("MYSQL_HOST: " + dotenv.get("MYSQL_HOST"));
		 System.out.println("MYSQL_USER: " + dotenv.get("MYSQL_USER"));
		 System.out.println("MYSQL_PASSWORD: " + dotenv.get("MYSQL_PASSWORD"));
		 System.out.println("MYSQL_DATABASE: " + dotenv.get("MYSQL_DATABASE"));
 
		 // Run Spring Boot application
		SpringApplication.run(FinanceTrackerApplication.class, args);
	}

}
