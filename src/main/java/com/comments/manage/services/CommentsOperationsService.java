package com.comments.manage.services;

import java.util.Optional;

import com.comments.manage.dto.Comments;
import com.comments.manage.dto.CommentsDTO;

public interface CommentsOperationsService {

	public Comments createComments(CommentsDTO comment);
	public Optional<Comments> updateComments(Long id,CommentsDTO comment);
	public Boolean deleteComment(Long id);
}
