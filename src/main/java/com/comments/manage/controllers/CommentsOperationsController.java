package com.comments.manage.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comments.manage.dto.Comments;
import com.comments.manage.dto.CommentsDTO;
import com.comments.manage.services.CommentsOperationsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2/comments")
public class CommentsOperationsController {
	
	
	@Autowired
	private CommentsOperationsService commentsOperationService;
	
	@PostMapping	
	public ResponseEntity<Comments> creatComment(@Valid @RequestBody CommentsDTO comment){
		
		return new ResponseEntity<Comments>(commentsOperationService.createComments(comment)
				,HttpStatus.CREATED);
	}
	
	@PutMapping(path = "/{id}")
	public ResponseEntity<Comments> updateComment(@PathVariable Long id, @Valid @RequestBody CommentsDTO commentToUpdate){
		Optional<Comments> updatedCommened = commentsOperationService.updateComments(id, commentToUpdate);
		return !updatedCommened.isEmpty()?
			new ResponseEntity<Comments>(updatedCommened.get(),HttpStatus.OK):
			new ResponseEntity<Comments>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable Long id){
		return commentsOperationService.deleteComment(id)? 
		new ResponseEntity<Object>(HttpStatus.NO_CONTENT)
		: new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
	
}
