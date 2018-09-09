package mypractice.service;

import mypractice.User;

public interface UserService {
    public User findUserByEmail(String email);
    public void saveUser(User user);

}

