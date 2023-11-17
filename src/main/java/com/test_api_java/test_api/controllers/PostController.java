package com.test_api_java.test_api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test_api_java.test_api.models.PostModel;
import com.test_api_java.test_api.services.PostService;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
  @Autowired
  PostService postService;

  @GetMapping
  public List<PostModel> getPosts() {
    return postService.getPosts();
  }

  @GetMapping("/{id}")
  public Optional<PostModel> getPost(@PathVariable("id") Integer id) {
    return postService.getPost(id);
  }

  @PostMapping
  public PostModel savePost(@RequestBody PostModel post) {
    return postService.savePost(post);
  }

  @PutMapping("/{id}")
  public PostModel updatePost(@RequestBody PostModel post, @PathVariable("id") Integer id) {
    return postService.updatePost(post, id);
  }

  @DeleteMapping("/{id}")
  public Boolean deletePost(@PathVariable("id") Integer id) {
    return postService.deletePost(id);
  }
}
