package victordgarcez.api_rest_cloud.API.service.impl;

import org.springframework.stereotype.Service;
import victordgarcez.api_rest_cloud.API.model.User;
import victordgarcez.api_rest_cloud.API.repository.UserRepository;
import victordgarcez.api_rest_cloud.API.service.UserService;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This user with account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
