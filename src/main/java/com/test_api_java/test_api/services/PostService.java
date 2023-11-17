package com.test_api_java.test_api.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test_api_java.test_api.models.PostModel;
import com.test_api_java.test_api.repositories.PostRepository;

@Service
public class PostService {
  @Autowired
  PostRepository postRepository;

  public List<PostModel> getPosts() {
    return postRepository.findAll();
  }

  public Optional<PostModel> getPost(Integer id) {
    return postRepository.findById(id);
  }

  public PostModel savePost(PostModel post) {
    post.setCreatedAt(new Timestamp(System.currentTimeMillis()));
    return postRepository.save(post);
  }

  public PostModel updatePost(PostModel request, Integer id) {
    PostModel post = postRepository.findById(id).get();

    post.setContent(request.getContent());
    // post.setUserId(request.getUserId());
    post.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
    postRepository.save(post);
    return post;
  }

  public Boolean deletePost(Integer id) {
    try {
      postRepository.deleteById(id);
      return true;
    } catch (Exception e) {
      return false;
    }
  }
}
