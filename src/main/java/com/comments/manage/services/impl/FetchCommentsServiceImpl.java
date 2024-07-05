package com.comments.manage.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comments.manage.dto.Comments;
import com.comments.manage.dto.CommentsDTO;
import com.comments.manage.repository.FetchCommentsRepository;
import com.comments.manage.services.FetchCommentsService;

@Service
public class FetchCommentsServiceImpl implements FetchCommentsService {

	@Autowired
	private FetchCommentsRepository fetchCommentsRepo;
	
	@Override
	public List<CommentsDTO> getAllComments(){
		
		 return getListCommentsDTO(fetchCommentsRepo.findAll());
		 
		
	}

	@Override
	public List<CommentsDTO> getAllCommentsByUser(String userName) {
		return getListCommentsDTO(fetchCommentsRepo.findByByuser(userName));
	}
	
	private List<CommentsDTO> getListCommentsDTO(List<Comments> cmnts){
		return cmnts.stream()
		 .map(cmnt -> CommentsDTO
				 .builder()
				 .Id(cmnt.getId())
				 .byuser(cmnt.getByuser())
				 .text(cmnt.getText())
				 .dateofcomment(cmnt.getDateofcomment()
				 ).build())
		 		.toList();
	}

	@Override
	public List<CommentsDTO> findByDateofcomment(Date dateofcomment) {
		
		return getListCommentsDTO(fetchCommentsRepo.findByDateofcomment(dateofcomment));
	}
	
	
}
