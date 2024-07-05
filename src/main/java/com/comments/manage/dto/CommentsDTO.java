package com.comments.manage.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentsDTO {

	private Long Id;
	
	@NotNull(message = "Username cannot be null!")
	private String byuser;
	
	@NotNull(message = "Text cannot be null!")
	private String text;

	@NotNull(message = "Date cannot be null!")
	private Date dateofcomment;
}
