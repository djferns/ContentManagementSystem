package com.dexter.cms.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dexter.cms.model.Article;

@Repository
public class ArticleDAOImpl implements ArticleDAO {

	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(article);
	}

	@Override
	public void updateArticle(Article article) {
		Session session = sessionFactory.getCurrentSession();
		session.update(article);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAllArticles() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article order by createdDate desc");
		List<Article> articles = query.list();
		return articles;
	}

	@Override
	public Article getArticle(int articleId) {
		Session session = sessionFactory.getCurrentSession();
		Article article = (Article) session.load(Article.class, articleId);
		return article;
	}

	@Override
	public void removeArticle(int articleId) {
		Session session = sessionFactory.getCurrentSession();
		Article article = (Article) session.get(Article.class, articleId);
		if(article != null){
			session.delete(article);
		}
	}

}
