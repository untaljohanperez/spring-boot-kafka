package udea.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import udea.user.model.User;

@Component
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    public void createOrUpdateUser(User user) {
        createUser(user);
    }

    private void createUser(User user) {
        LOGGER.info("Creating user " + user.toString());
    }
}
