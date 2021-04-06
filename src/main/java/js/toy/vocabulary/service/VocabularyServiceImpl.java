package js.toy.vocabulary.service;

import js.toy.vocabulary.repository.VocabularyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VocabularyServiceImpl implements VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    @Override
    public Object test() {
        return vocabularyRepository.findAll();
    }
}
