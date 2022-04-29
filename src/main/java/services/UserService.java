package services;

import entities.User;
import exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

        User createUser(User user)
        {
            return userRepository.save(user);
        }

        User updateUser(User user,Integer userID)
        {
            User updatedUser=userRepository.findById(userID).
                    orElseThrow(()->new ResourceNotFoundException("User","id",userID));
            user.setName(updatedUser.getName());
            user.setEmail(updatedUser.getEmail());
            user.setPassword(updatedUser.getPassword());
            user.setAbout(updatedUser.getAbout());
            return this.userRepository.save(user);
        }
        User getUserById(Integer userID) {

            User user=userRepository.findById(userID).
                    orElseThrow(()->new ResourceNotFoundException("User","id",userID));
            return user;
        }

        List<User> getAllUsers(){
            List<User> users=this.userRepository.findAll();
            return users;
        }

        void deleteUser(Integer userId){
            User user=userRepository.findById(userId).
                    orElseThrow(()->new ResourceNotFoundException("User","id",userId));
            this.userRepository.deleteById(userId);

        }
}
