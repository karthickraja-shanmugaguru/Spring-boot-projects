package com.example.firstdemo.Service;
import com.example.firstdemo.entity.User;
import com.example.firstdemo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public User createUser(User user){
        return  userRepository.save(user);
    }
    public User updateUser(User user,Long id){
        User update = userRepository.findById(id).get();
        update.setName(user.getName());
        return userRepository.save(update);

    }
    public String deleteUser(Long id){
        if(userRepository.findById(id).isPresent()){
            userRepository.deleteById(id);
            return  "deleted";
        }
        return null;
    }
    public User selectUser(Long id){
        if(userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        return  null;
    }
    public List<User> selectAll(){
        return userRepository.findAll();
    }
}
