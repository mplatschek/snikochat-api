package de.martinplatschek.snikochatapi;

import de.martinplatschek.snikochatapi.repository.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SnikochatAPI {
	public static void main(String[] args) {
		SpringApplication.run(SnikochatAPI.class, args);
	}
}
