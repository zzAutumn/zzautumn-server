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

    Article saveOne(String title, String content, String imgBanner, String intro, List<String> tags, Integer id);

    PageVO getArticleList(Integer pageIndex, Integer pageSize, String title);

    Boolean deleteOne(Integer id);

    Article getOne(Integer id);
}
