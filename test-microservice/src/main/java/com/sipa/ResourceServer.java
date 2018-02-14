package com.sipa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@SpringBootApplication
@RestController
//@EnableResourceServer
public class ResourceServer {

	@RequestMapping("/")
	public Message home() {
		return new Message("Hello World");
	}

	public static void main(String[] args) {
		SpringApplication.run(ResourceServer.class, args);
	}
}

class Message {
	private String id = UUID.randomUUID().toString();
	private String content;

	public Message(String content) {
		this.content = content;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
}
