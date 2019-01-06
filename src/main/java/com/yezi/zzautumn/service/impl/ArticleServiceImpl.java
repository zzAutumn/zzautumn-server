package com.yezi.zzautumn.service.impl;

import com.yezi.zzautumn.domain.Article;
import com.yezi.zzautumn.repository.ArticleRepository;
import com.yezi.zzautumn.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * @Author: yezi
 * @Date: 2019/1/6 15 42
 * @Description:
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article saveOne(String title, String content, Collection<String> tags) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        return articleRepository.save(article);
    }
}
