package com.hackathon.kangnengthon;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class KangnengthonApplication {
	private static final Logger logger = LoggerFactory.getLogger(KangnengthonApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(KangnengthonApplication.class, args);
		logger.info("Application has started.");
	}

}
