package com.comments.manage.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.manage.dto.Comments;
import com.comments.manage.dto.CommentsDTO;
import com.comments.manage.repository.CommentsOperatoinsRepository;
import com.comments.manage.services.CommentsOperationsService;

@Service
public class CommentsOperationsServiceImpl implements CommentsOperationsService {

	@Autowired
	private CommentsOperatoinsRepository commentsOperationRepo;
	
	public Comments createComments(CommentsDTO comment) {
			
		Comments cmt = Comments.builder()
				.byuser(comment.getByuser())
				.dateofcomment(comment.getDateofcomment())
				.text(comment.getText())
				.build();
		
		return commentsOperationRepo.save(cmt);
	}

	@Override
	public Optional<Comments> updateComments(Long Id,CommentsDTO commentToUpdate) {
		return commentsOperationRepo.findById(Id).map(existingCmnt ->{		
			existingCmnt.setByuser(commentToUpdate.getByuser());
			existingCmnt.setDateofcomment(commentToUpdate.getDateofcomment());
			existingCmnt.setText(commentToUpdate.getText());	
			return commentsOperationRepo.save(existingCmnt);
		});		
	}

	@Override
	public Boolean deleteComment(Long id) {
		if(commentsOperationRepo.existsById(id)) {
			commentsOperationRepo.deleteById(id);
			return true;
		}
		return false;
	} 
	
	
}
