package com.dexter.cms.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2872674427156694093L;

	@Id
	@Column(name="comment_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int commentId;
	
	@Column(name="comment_name")
	private String commentName;
	
	@Column(name="comment_author")
	private String commentAuthor;
	
	@Column(name="comment_create_date")
	private Date createdDate;
	
	/**
	 * 
	 */
	public Comment() {
		
	}

	/**
	 * @param commentName
	 * @param commentAuthor
	 * @param createdDate
	 */
	public Comment(String commentName, String commentAuthor) {
		super();
		this.commentName = commentName;
		this.commentAuthor = commentAuthor;
		this.createdDate = new Date();
	}

	/**
	 * @param commentName
	 * @param commentAuthor
	 * @param createdDate
	 */
	public Comment(String commentName, String commentAuthor, Date createdDate) {
		super();
		this.commentName = commentName;
		this.commentAuthor = commentAuthor;
		this.createdDate = createdDate;
	}

	/**
	 * @param commentId
	 * @param commentName
	 * @param commentAuthor
	 * @param createdDate
	 */
	public Comment(int commentId, String commentName, String commentAuthor) {
		super();
		this.commentId = commentId;
		this.commentName = commentName;
		this.commentAuthor = commentAuthor;
		this.createdDate = new Date();
	}

	/**
	 * @return the commentId
	 */
	public int getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the commentName
	 */
	public String getCommentName() {
		return commentName;
	}

	/**
	 * @param commentName the commentName to set
	 */
	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	/**
	 * @return the commentAuthor
	 */
	public String getCommentAuthor() {
		return commentAuthor;
	}

	/**
	 * @param commentAuthor the commentAuthor to set
	 */
	public void setCommentAuthor(String commentAuthor) {
		this.commentAuthor = commentAuthor;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
