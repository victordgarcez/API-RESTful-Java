package victordgarcez.api_rest_cloud.API.service;

import victordgarcez.api_rest_cloud.API.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
}
