package com.bhavasi.practice.graphql;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@AllArgsConstructor
@EnableMongoRepositories
@SpringBootApplication
public class GraphqlApplication implements CommandLineRunner {

	private final MongoDbInitializer mongoDbInitializer;

	public static void main(String[] args) {
		SpringApplication.run(GraphqlApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mongoDbInitializer.init();
	}
}
