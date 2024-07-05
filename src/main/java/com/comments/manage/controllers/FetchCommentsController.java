package com.comments.manage.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comments.manage.dto.CommentsDTO;
import com.comments.manage.services.FetchCommentsService;

@RestController
@RequestMapping("/api/v2/comments")
public class FetchCommentsController {

	@Autowired
	private FetchCommentsService fetchCommentService;
	
	@GetMapping
	public ResponseEntity<List<CommentsDTO>> getAllComments(){
		List<CommentsDTO> allComments = fetchCommentService.getAllComments();
		return new ResponseEntity<List<CommentsDTO>> (allComments, HttpStatus.OK);
	}
	
	@GetMapping(path = "/search",
			params = "username")
	public ResponseEntity<List<CommentsDTO>> getAllCommentsByUser(@RequestParam("username") String username){
		List<CommentsDTO> allComments = fetchCommentService.getAllCommentsByUser(username);
		return new ResponseEntity<List<CommentsDTO>> (allComments, HttpStatus.OK);
	}
	
	@GetMapping(path = "/search",
			params = "date") 
	public ResponseEntity<List<CommentsDTO>> getAllCommentsByDate(@RequestParam("date") @DateTimeFormat(pattern= "yyyy-MM-dd") Date date){
		List<CommentsDTO> allComments = fetchCommentService.findByDateofcomment(date);
		return new ResponseEntity<List<CommentsDTO>> (allComments, HttpStatus.OK);
	}
}
