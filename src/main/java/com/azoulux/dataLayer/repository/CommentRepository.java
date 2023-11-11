package com.azoulux.dataLayer.repository;

import org.springframework.data.repository.CrudRepository;

import com.azoulux.dataLayer.model.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Integer> {
}
