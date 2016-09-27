package com.dexter.cms.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dexter.cms.model.Article;
import com.dexter.cms.model.Comment;
import com.dexter.cms.service.ArticleService;
import com.dexter.cms.service.CommentService;

@Controller
public class CommentController {

	private ArticleService articleService;
	
	private CommentService commentService;

	/**
	 * @param articleService
	 */
	@Autowired(required=true)
	@Qualifier(value="articleService")
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	/**
	 * @param commentService the commentService to set
	 */
	@Autowired(required=true)
	@Qualifier(value="commentService")
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@RequestMapping(value = "/addComment/{articleId}", method = RequestMethod.GET)
	public String getCommentAddPage(@PathVariable("articleId") int articleId, Model model) {
		Article article = articleService.getArticle(articleId);
		List<Comment> listComments = article.getComments();
		article.setComments(new ArrayList<Comment>());
		model.addAttribute("article", article);
		model.addAttribute("listComments", listComments);
		return "comment";
	}
	
	@RequestMapping(value="/comment/add", method=RequestMethod.POST)
	public String addComment(@ModelAttribute("article") Article article){
		Comment comment = article.getComments().get(0);
		comment.setCreatedDate(new Date());
		comment.setArticle(article);
		commentService.addComment(comment);
		String url = "redirect:/addComment/" + article.getId();
		return url;
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
}
