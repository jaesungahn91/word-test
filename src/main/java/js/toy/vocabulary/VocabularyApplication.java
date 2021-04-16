package js.toy.vocabulary;

import js.toy.vocabulary.entity.Voca;
import js.toy.vocabulary.repository.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;

// Spring Audit 기능을 활용하기 위해 우선 @EnableJpaAuditing 어노테이션을 추가
@EnableJpaAuditing
@SpringBootApplication
public class VocabularyApplication {

	@Autowired
    VocabularyRepository vocabularyRepository;

	public static void main(String[] args) {
		SpringApplication.run(VocabularyApplication.class, args);
	}

	// 초기화 작업 할 메소드, 해당 어노테이션이 적용된 초기화 메서드는 WAS가 띄워질 때 실행
	@PostConstruct
	public void init(){
		vocabularyRepository.save(new Voca(1L, "hello", "하이"));
	}

}
