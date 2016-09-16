package com.dexter.cms.service;

import java.util.List;

import com.dexter.cms.model.Comment;

public interface CommentService {

	public List<Comment> getCommentsForId(int articleId);
	
}
