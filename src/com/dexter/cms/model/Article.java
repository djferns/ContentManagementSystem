package com.dexter.cms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy=false)
@Table(name="ARTICLE")
public class Article implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2430703876005425704L;

	@Id
	@Column(name="article_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="article_title")
	private String title;
	
	@Column(name="article_author")
	private String author;
	
	@Column(name="article_summary")
	private String summary;
	
	@Column(name="article_content")
	private String content;
	
	@Column(name="article_create_date")
	private Date createdDate;
	
	@Column(name="article_file_name")
	private String fileName;
	
	@Column(name="article_file_location")
	private String fileLocation;
	
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="article_id")
	@Cascade(CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	
	/**
	 * 
	 */
	public Article() {
		
	}

	/**
	 * @param id
	 * @param title
	 * @param author
	 * @param summary
	 * @param content
	 * @param fileName
	 * @param fileLocation
	 */
	public Article(int id, String title, String author, String summary, String content, String fileName,
			String fileLocation) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.summary = summary;
		this.content = content;
		this.createdDate = new Date();
		this.fileName = fileName;
		this.fileLocation = fileLocation;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
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

	/**
	 * @return the comments
	 */
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the fileLocation
	 */
	public String getFileLocation() {
		return fileLocation;
	}

	/**
	 * @param fileLocation the fileLocation to set
	 */
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

}
