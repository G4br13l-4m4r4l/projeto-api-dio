package dio.projeto_api_dio.service.impl;

import dio.projeto_api_dio.model.User;
import dio.projeto_api_dio.repository.UserRepository;
import dio.projeto_api_dio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;


public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
       if(userToCreate.getId() != null && userRepository.existsById(userToCreate.getId())) {
           throw new IllegalArgumentException("User already exists!");
       }else{
           return userRepository.save(userToCreate);
       }
    }
}
