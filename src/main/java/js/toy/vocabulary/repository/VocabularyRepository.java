package js.toy.vocabulary.repository;


import js.toy.vocabulary.entity.Voca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyRepository extends JpaRepository<Voca, Long> {
}
