package com.api.solset.service;

import com.api.solset.dto.UserDTO;
import com.api.solset.model.User;
import com.api.solset.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientService clientService;

    public List<UserDTO> findAll(){
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : userRepository.findAll()){
            UserDTO userDTO = new UserDTO();
            userDTO.setUser(user);
            userDTO.setClients(clientService.findByUserId(user.getId()));
            userDTOList.add(userDTO);
        }
        return userDTOList;
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
