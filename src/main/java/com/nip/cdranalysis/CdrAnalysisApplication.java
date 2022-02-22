package com.nip.cdranalysis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableNeo4jRepositories("com.nip.cdranalysis.repository")
@EntityScan("com.nip.cdranalysis.model")
@EnableTransactionManagement
public class CdrAnalysisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdrAnalysisApplication.class, args);
	}

}
