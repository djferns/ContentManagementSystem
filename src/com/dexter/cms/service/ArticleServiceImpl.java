package com.dexter.cms.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dexter.cms.dao.ArticleDAO;
import com.dexter.cms.model.Article;

@Service
public class ArticleServiceImpl implements ArticleService {

	private ArticleDAO articleDAO;
	
	/**
	 * @param articleDAO the articleDAO to set
	 */
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	@Override
	@Transactional
	public void addArticle(Article article) {
		articleDAO.addArticle(article);
	}

	@Override
	@Transactional
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}

	@Override
	@Transactional
	public List<Article> getAllArticles() {
		return articleDAO.getAllArticles();
	}

	@Override
	@Transactional
	public Article getArticle(int articleId) {
		return articleDAO.getArticle(articleId);
	}

	@Override
	@Transactional
	public void removeArticle(int articleId) {
		articleDAO.removeArticle(articleId);
	}

}
