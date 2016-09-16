package com.dexter.cms.service;

import java.util.List;

import com.dexter.cms.model.Article;

public interface ArticleService {

	public void addArticle(Article article);
	public void updateArticle(Article article);
	public List<Article> getAllArticles();
	public Article getArticle(int articleId);
	public void removeArticle(int articleId);
	
}
