package com.comments.manage.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comments.manage.dto.Comments;

public interface FetchCommentsRepository extends JpaRepository<Comments, Long>{

	public List<Comments> findByByuser(String byuser);
	public List<Comments> findByDateofcomment(Date dateofcomment);
}
