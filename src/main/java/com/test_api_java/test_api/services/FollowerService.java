package com.test_api_java.test_api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_api_java.test_api.models.FollowerModel;
import com.test_api_java.test_api.repositories.FollowerRepository;

@Service
public class FollowerService {

  @Autowired
  FollowerRepository followerRepository;

  public List<FollowerModel> followers(Integer id) {
    return followerRepository.findByFollowedId(id);
  }

  public Integer followersCount(Integer id) {
    return followerRepository.findByFollowedId(id).size();
  }

  public List<FollowerModel> following(Integer id) {
    return followerRepository.findByFollowerId(id);
  }

  public Integer followingCount(Integer id) {
    return followerRepository.findByFollowerId(id).size();
  }

  public FollowerModel follow(FollowerModel follower) {
    return followerRepository.save(follower);
  }

  public Boolean unfollow(Integer id) {
    try {
      followerRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
  
}
