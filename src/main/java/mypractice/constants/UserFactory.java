package mypractice.constants;

import mypractice.User;

public class UserFactory {

    private UserFactory() {
    }

    public static User create(User user) {
        return new User(
                user.getId(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }

}
