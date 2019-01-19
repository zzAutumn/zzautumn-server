package com.yezi.zzautumn.service;

import com.yezi.zzautumn.domain.Article;
import com.yezi.zzautumn.vo.PageVO;

import java.util.Collection;
import java.util.List;

/**
 * @Author: yezi
 * @Date: 2019/1/6 15 20
 * @Description:
 */
public interface ArticleService {

    Article saveOne(String title, String content, List<String> tags);

    PageVO getArticleList(Integer pageIndex, Integer pageSize, String title);
}
