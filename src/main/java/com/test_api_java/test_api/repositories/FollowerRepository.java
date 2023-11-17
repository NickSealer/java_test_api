package com.test_api_java.test_api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test_api_java.test_api.models.FollowerModel;


@Repository
public interface FollowerRepository extends JpaRepository<FollowerModel, Integer> {
  
  List<FollowerModel> findByFollowedId(Integer followedId);
  List<FollowerModel> findByFollowerId(Integer followerId);
  
}
