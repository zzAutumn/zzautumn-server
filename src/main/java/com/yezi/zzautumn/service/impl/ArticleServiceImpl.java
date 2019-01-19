package com.yezi.zzautumn.service.impl;

import com.yezi.zzautumn.domain.Article;
import com.yezi.zzautumn.repository.ArticleRepository;
import com.yezi.zzautumn.service.ArticleService;
import com.yezi.zzautumn.vo.PageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    public Article saveOne(String title, String content, List<String> tags) {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        String savedTags = tags.stream().collect(Collectors.joining(","));
        article.setAssignTags(savedTags);
        return articleRepository.save(article);
    }

    @Override
    public PageVO getArticleList(Integer pageIndex, Integer pageSize, String title) {

        Sort sort = new Sort(Sort.Direction.DESC, "updateDate");
        Pageable page = PageRequest.of(pageIndex - 1, pageSize, sort);
        Page<Article> articles = articleRepository.findArticlesByTitleIsLike(title, page);
        return PageVO.make(articles);
    }
}
