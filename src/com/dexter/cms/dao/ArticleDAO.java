package com.dexter.cms.dao;

import java.util.List;

import com.dexter.cms.model.Article;

public interface ArticleDAO {
	
	public void addArticle(Article article);
	public void updateArticle(Article article);
	public List<Article> getAllArticles();
	public Article getArticle(int articleId);
	public void removeArticle(int articleId);

}
