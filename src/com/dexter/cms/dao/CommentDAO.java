package com.dexter.cms.dao;

import java.util.List;

import com.dexter.cms.model.Comment;

public interface CommentDAO {

	public void addComment(Comment comment);
	
	public List<Comment> getCommentsForId(int articleId);
	
}
