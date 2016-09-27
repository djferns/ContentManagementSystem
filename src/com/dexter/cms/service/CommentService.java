package com.dexter.cms.service;

import java.util.List;

import com.dexter.cms.model.Comment;

public interface CommentService {

	public void addComment(Comment comment);
	
	public List<Comment> getCommentsForId(int articleId);
	
}
