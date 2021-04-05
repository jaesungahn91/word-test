package com.js.vocatest;

import com.js.vocatest.entity.Voca;
import com.js.vocatest.repository.VocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

// Spring Audit 기능을 활용하기 위해 우선 @EnableJpaAuditing 어노테이션을 추가
@EnableJpaAuditing
@SpringBootApplication
public class VocaTestApplication {

	@Autowired
	VocaRepository vocaRepository;

	public static void main(String[] args) {
		SpringApplication.run(VocaTestApplication.class, args);
	}

	@PostConstruct
	public void init(){
		vocaRepository.save(new Voca(1L, "hello", "하이"));
	}

}
