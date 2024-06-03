package dio.projeto_api_dio.service;

import dio.projeto_api_dio.model.User;

public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
}
