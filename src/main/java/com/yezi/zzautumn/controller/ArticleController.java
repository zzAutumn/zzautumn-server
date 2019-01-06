package com.yezi.zzautumn.controller;

import com.yezi.zzautumn.domain.Article;
import com.yezi.zzautumn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

/**
 * @Author: yezi
 * @Date: 2019/1/6 15 51
 * @Description:
 */
@RestController
@RequestMapping("/zzautumn/v1/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/save-article", method = {RequestMethod.POST, RequestMethod.GET})
    public Object saveArticle(String title,String content,@RequestParam List<String> tags) {
        Article article = articleService.saveOne(title, content, tags);

        return article;
    }
}
