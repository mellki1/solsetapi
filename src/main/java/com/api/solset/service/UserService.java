package com.api.solset.service;

import com.api.solset.dto.UserRequestDTO;
import com.api.solset.dto.UserResponseDTO;
import com.api.solset.mapper.UserMapper;
import com.api.solset.model.User;
import com.api.solset.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientService clientService;

    public List<User> listAll(){
        return userRepository.findAll();
    }

    public List<UserResponseDTO> listAllWithRelationship(){
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : userRepository.findAll()){
            UserResponseDTO userResponseDTO = UserMapper.INSTANCE.toUserResponseDTO(user);
            userResponseDTO.setClients(clientService.listAllWithRelationship());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    public User findByIdOrElseThrow(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proposal not found"));
    }

    public User findUserByRequestToken(String requestToken){
        return userRepository.findByRequestToken(requestToken);
    }

    public UserResponseDTO findByRequestToken(String requestToken){
        User user =  userRepository.findByRequestToken(requestToken);
        UserResponseDTO userResponseDTO = UserMapper.INSTANCE.toUserResponseDTO(user);
        userResponseDTO.setClients(clientService.findByUserRequestToken(userResponseDTO.getRequestToken()));
        return userResponseDTO;
    }

    public User save(UserRequestDTO userRequestDTO){
        User user = UserMapper.INSTANCE.toUser(userRequestDTO);
        return userRepository.save(user);
    }

    public void update(UserRequestDTO userRequestDTO){
        User budgetSaved = findByIdOrElseThrow(userRequestDTO.getId());
        User newBudget = UserMapper.INSTANCE.toUser(userRequestDTO);
        newBudget.setId(budgetSaved.getId());
        userRepository.save(newBudget);
    }

    public void delete(String userToken){
        User user = this.findUserByRequestToken(userToken);
        userRepository.deleteById(user.getId());
    }
}
