package com.api.solset.service;

import com.api.solset.model.User;
import com.api.solset.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }

    public User update(User user){
        this.delete(user.getId());
        return userRepository.save(user);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }
}
