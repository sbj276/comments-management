package com.comments.manage.services;

import java.util.Date;
import java.util.List;

import com.comments.manage.dto.Comments;
import com.comments.manage.dto.CommentsDTO;


public interface FetchCommentsService {

	public List<CommentsDTO> getAllComments();
	public List<CommentsDTO> getAllCommentsByUser(String userName);
	public List<CommentsDTO> findByDateofcomment(Date dateofcomment);

}
