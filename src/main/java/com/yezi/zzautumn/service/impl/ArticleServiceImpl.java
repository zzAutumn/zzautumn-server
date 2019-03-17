package com.yezi.zzautumn.service.impl;

import com.yezi.zzautumn.domain.Article;
import com.yezi.zzautumn.repository.ArticleRepository;
import com.yezi.zzautumn.service.ArticleService;
import com.yezi.zzautumn.vo.PageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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
    public Article saveOne(String title, String content, String imgBanner,String intro, List<String> tags, Integer id) {
        Article returnValue = null;
        if (null != id) {
            Optional<Article> savedArticle = articleRepository.findById(id);
            if (savedArticle.isPresent()) {
                Article article = savedArticle.get();
                article.setId(id);
                article.setUpdateDate(new Date());
                article.setTitle(title);
                article.setImgBanner(imgBanner);
                article.setIntro(intro);
                article.setContent(content);
                String savedTags = tags.stream().collect(Collectors.joining(","));
                article.setAssignTags(savedTags);
                returnValue = articleRepository.save(article);
            }
        } else {
            Article article = new Article();
            article.setTitle(title);
            article.setContent(content);
            article.setImgBanner(imgBanner);
            article.setIntro(intro);
            String savedTags = tags.stream().collect(Collectors.joining(","));
            article.setAssignTags(savedTags);
            returnValue = articleRepository.save(article);
        }
        return returnValue;
    }

    @Override
    public PageVO getArticleList(Integer pageIndex, Integer pageSize, String title) {

        Sort sort = new Sort(Sort.Direction.DESC, "updateDate");
        Pageable page = PageRequest.of(pageIndex - 1, pageSize, sort);
        if (StringUtils.isBlank(title)){
            title="";
        }
        Page<Article> articles = articleRepository.findArticlesByTitleIsLikeAndDeletedIsFalse("%"+title+"%", page);
        return PageVO.make(articles);
    }

    @Override
    public Boolean deleteOne(Integer id) {

        Optional<Article> article = articleRepository.findById(id);
        article.ifPresent(a -> {
            a.setDeleted(true);
            a.setUpdateDate(new Date());
            articleRepository.saveAndFlush(a);
        });
        return true;
    }

    @Override
    public Article getOne(Integer id) {
        Optional<Article> article = articleRepository.findByIdAndDeletedIsFalse(id);
        return article.orElse(null);
    }
}
