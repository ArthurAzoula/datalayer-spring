package com.azoulux.dataLayer.service;

import com.azoulux.dataLayer.model.Comment;
import com.azoulux.dataLayer.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {

	@Autowired
	private CommentRepository commentRepository;

	public Iterable<Comment> getComments() {
		return commentRepository.findAll();
	}

	public Optional<Comment> getCommentById(Integer id) {
		return commentRepository.findById(id);
	}

	public void deleteCommentById(Integer id) {
		commentRepository.deleteById(id);
	}

}
