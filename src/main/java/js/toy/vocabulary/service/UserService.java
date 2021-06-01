package js.toy.vocabulary.service;

import js.toy.vocabulary.dto.response.UserResult;

public interface UserService {
    UserResult getUserByEmail(String email);
}
