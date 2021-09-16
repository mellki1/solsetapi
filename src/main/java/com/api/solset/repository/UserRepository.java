package com.api.solset.repository;

import com.api.solset.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findByRequestToken(String userToken);
    User findByRequestTokenAndMasterName(String userToken, String masterName);
    List<User> findByMasterName(String masterName);
}
