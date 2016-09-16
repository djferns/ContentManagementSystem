package com.dexter.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexter.cms.dao.CommentDAO;
import com.dexter.cms.model.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	private CommentDAO commentDAO;
	
	/**
	 * @param commentDAO the commentDAO to set
	 */
	public void setCommentDAO(CommentDAO commentDAO) {
		this.commentDAO = commentDAO;
	}

	@Override
	@Transactional
	public List<Comment> getCommentsForId(int articleId) {
		return commentDAO.getCommentsForId(articleId);
	}

}
