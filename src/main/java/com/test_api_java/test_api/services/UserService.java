package com.test_api_java.test_api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_api_java.test_api.models.UserModel;
import com.test_api_java.test_api.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;

  public List<UserModel> getUsers() {
    return userRepository.findAll();
  }

  public Optional<UserModel> getUser(Integer id) {
    return userRepository.findById(id);
  }

  public UserModel saveUser(UserModel user) {
    return userRepository.save(user);
  }

  public UserModel updateUser(UserModel request, Integer id) {
    UserModel user = userRepository.findById(id).get();

    user.setName(request.getName());
    user.setUsername(request.getUsername());
    user.setEmail(request.getEmail());
    user.setPassword(request.getPassword());
    userRepository.save(user);
    return user;
  }

  public Boolean deleteUser(Integer id) {
    try {
      userRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
