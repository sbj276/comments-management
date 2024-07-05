package com.comments.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comments.manage.dto.Comments;

public interface CommentsOperatoinsRepository extends JpaRepository<Comments, Long> {

}
