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

    public List<User> listAll() {
        return userRepository.findAll();
    }

    public List<UserResponseDTO> findAllWithRelationship(String masterName) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        List<User> userList = null;
        if (masterName.equals("ALL")) {
            userList = userRepository.findAll();
        } else {
            userList = userRepository.findByMasterName(masterName);
        }
        for (User user : userList) {
            UserResponseDTO userResponseDTO = UserMapper.INSTANCE.toUserResponseDTO(user);
            if (masterName.equals("ALL")) {
                userResponseDTO.setClients(clientService.listAllWithRelationship("ALL"));
            } else {
                userResponseDTO.setClients(clientService.findByUserRequestToken(user.getRequestToken()));
            }
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    public User findByIdOrElseThrow(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proposal not found"));
    }

    public User findUserByRequestToken(String requestToken) {
        return userRepository.findByRequestToken(requestToken);
    }

    public UserResponseDTO findByRequestToken(String requestToken, String masterName) {
        User user = null;
        if (masterName.equals("ALL")) {
            user = userRepository.findByRequestToken(requestToken);
        } else {
            user = userRepository.findByRequestTokenAndMasterName(requestToken, masterName);
        }
        UserResponseDTO userResponseDTO = UserMapper.INSTANCE.toUserResponseDTO(user);
        userResponseDTO.setClients(clientService.findByUserRequestToken(userResponseDTO.getRequestToken()));
        return userResponseDTO;
    }

    public User save(UserRequestDTO userRequestDTO) {
        User user = UserMapper.INSTANCE.toUser(userRequestDTO);
        return userRepository.save(user);
    }

    public void update(Long id, UserRequestDTO userRequestDTO) {
        User budgetSaved = findByIdOrElseThrow(id);
        User newBudget = UserMapper.INSTANCE.toUser(userRequestDTO);
        newBudget.setId(budgetSaved.getId());
        userRepository.save(newBudget);
    }

    public void delete(String userToken) {
        User user = this.findUserByRequestToken(userToken);
        userRepository.deleteById(user.getId());
    }
}
