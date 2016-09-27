package com.dexter.cms.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dexter.cms.model.Article;
import com.dexter.cms.service.ArticleService;

@Controller
public class ArticleController {

	private ArticleService articleService;

	/**
	 * @param articleService
	 */
	@Autowired(required=true)
	@Qualifier(value="articleService")
	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	@RequestMapping("/")
	public String displayHomePage(Model model) {
		return "home";
	}

	@RequestMapping(value = "/addArticle", method = RequestMethod.GET)
	public String getArticleAddPage(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "article";
	}


	@RequestMapping(value="/article/add", method=RequestMethod.POST)
	public String addArticle(@ModelAttribute("article") Article article, @RequestParam("file") MultipartFile file){

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				switch(file.getContentType()){

				case "image/png" : article.setFileName(article.getFileName() + ".png");
									break;

				case "image/jpg" : article.setFileName(article.getFileName() + ".jpg");
									break;

				}

				// Creating the directory to store file
				String rootPath = "C:/Users/user/Documents/CourseSessions/HibernateSession/ContentManagementSystem/WebContent";
				File dir = new File(rootPath + File.separator + "uploadedFiles");
				if (!dir.exists())
					dir.mkdirs();

				String fileLocation = dir.getAbsolutePath() + File.separator + article.getFileName();
				article.setFileLocation(fileLocation);

				// Create the file on server
				File serverFile = new File(fileLocation);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				return "You failed to upload " + article.getFileName() + " => " + e.getMessage();
			}
		}

		article.setCreatedDate(new Date());
		if(article.getId() == 0){
			articleService.addArticle(article);
		}else{
			articleService.updateArticle(article);
		}

		return "redirect:/";
	}

	@RequestMapping("/viewArticle/{articleId}")
	public String viewArticle(@PathVariable("articleId") int articleId, Model model){
		model.addAttribute("article", articleService.getArticle(articleId));
		return "viewArticle";
	}

	@RequestMapping("/editArticle/{articleId}")
	public String updateArticle(@PathVariable("articleId") int articleId, Model model){
		model.addAttribute("article", articleService.getArticle(articleId));
		return "article";
	}

	@RequestMapping("/removeArticle/{articleId}")
	public String removeArticle(@PathVariable("articleId") int articleId){

		articleService.removeArticle(articleId);
		return "redirect:/";
	}

	@RequestMapping(value = "/getAllArticles/{action}", method = RequestMethod.GET)
	public String listArticles(@PathVariable("action") String action, Model model) {
		if(action!=null && !action.isEmpty()){
			if(action.equalsIgnoreCase("updateArticle")){
				action = "Edit";
			}else if(action.equalsIgnoreCase("deleteArticle")){
				action = "Delete";
			}else if(action.equalsIgnoreCase("list")){
				action = "List";
			}else if(action.equalsIgnoreCase("addComment")){
				action = "Comment";
			}else{
				return "redirect:/";
			}
		}else{
			return "redirect:/";
		}
		model.addAttribute("actionValue", action);
		model.addAttribute("listArticles", articleService.getAllArticles());
		return "articles";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}

}
