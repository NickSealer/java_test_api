package com.test_api_java.test_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test_api_java.test_api.models.PostModel;

@Repository
public interface PostRepository extends JpaRepository<PostModel, Integer> {
  
}
