package com.spring.blog.services;

import com.spring.blog.entities.User;
import com.spring.blog.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.blog.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user, Integer userID) {
        User updatedUser = userRepository.findById(userID).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", userID));
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPassword(updatedUser.getPassword());
        user.setAbout(updatedUser.getAbout());
        return this.userRepository.save(user);
    }

    public User getUserById(Integer userID) {

        User user = userRepository.findById(userID).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", userID));
        return user;
    }

    public List<User> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public void deleteUser(Integer userId) {
        User user = userRepository.findById(userId).
                orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
        this.userRepository.deleteById(userId);

    }
}
