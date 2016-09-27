package com.dexter.cms.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dexter.cms.model.Comment;

@Repository
public class CommentDAOImpl implements CommentDAO {

	private SessionFactory sessionFactory;
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/* (non-Javadoc)
	 * @see com.dexter.cms.dao.CommentDAO#addComment(int)
	 */
	@Override
	public void addComment(Comment comment) {
		Session session = sessionFactory.getCurrentSession();
		session.save(comment);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List<Comment> getCommentsForId(int articleId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createSQLQuery("select comment_name,comment_author,comment_create_date from comment where article_id = :articleId");
		query.setParameter("articleId", articleId);
		List objects = query.list();
		
		List<Comment> comments = new ArrayList<>();
		
		for(int i = 0; i < objects.size(); i++){
			Object[] row = (Object[]) objects.get(i);
			Comment comment = new Comment(row[0].toString(), row[1].toString(), (Date) row[2]);
			comments.add(comment);
		}
		
		return comments;
	}

}
