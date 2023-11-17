package com.test_api_java.test_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test_api_java.test_api.models.FollowerModel;
import com.test_api_java.test_api.services.FollowerService;

@RestController
@RequestMapping("/api/v1")
public class FollowerController {

  @Autowired
  FollowerService followerService;

  @GetMapping("followers/{id}")
  public List<FollowerModel> followers(@PathVariable("id") Integer id) {
    return followerService.followers(id);
  }

  @GetMapping("followers/{id}/count")
  public Integer followersCount(@PathVariable("id") Integer id) {
    return followerService.followersCount(id);
  }

  @GetMapping("following/{id}")
  public List<FollowerModel> following(@PathVariable("id") Integer id) {
    return followerService.following(id);
  }

  @RequestMapping("following/{id}/count")
  public Integer followingCount(@PathVariable("id") Integer id) {
    return followerService.followingCount(id);
  }

  @PostMapping("followers")
  public FollowerModel follow(@RequestBody FollowerModel follower) {
    return followerService.follow(follower);
  }

  @DeleteMapping("followers/{id}")
  public Boolean unfollow(@PathVariable("id") Integer id) {
    return followerService.unfollow(id);
  }
  
}
