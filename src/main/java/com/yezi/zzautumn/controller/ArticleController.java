package com.yezi.zzautumn.controller;

import com.yezi.zzautumn.domain.Article;
import com.yezi.zzautumn.service.ArticleService;
import com.yezi.zzautumn.utils.OperationResult;
import com.yezi.zzautumn.vo.PageVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "文章管理", description = "文章管理")
@RestController
@RequestMapping("/zzautumn/v1/article")
public class ArticleController extends BaseController{

    @Autowired
    ArticleService articleService;

    @RequestMapping(value = "/save-article", method = {RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "保存文章")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = true, paramType = "query"),
            @ApiImplicitParam(name = "content", value = "文章内容", required = true, paramType = "query"),
            @ApiImplicitParam(name = "tags", value = "文章标签", required = true, paramType = "query", allowMultiple = true)
    })
    public OperationResult saveArticle(String title, String content, @RequestParam List<String> tags) {

        return processSimple((r) -> {
            Article article = articleService.saveOne(title, content, tags);
            r.setData(article);
        });
    }

    @RequestMapping(value = "/getArticleList", method = { RequestMethod.POST, RequestMethod.GET})
    @ApiOperation(value = "获取文章列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "title", value = "文章标题", required = false)
    })
    public OperationResult getArticleList(String title, @RequestParam(defaultValue = "1") Integer pageIndex,
                                          @RequestParam(defaultValue = "10") Integer pageSize) {
        return processSimple((r) -> {
            PageVO articleList = this.articleService.getArticleList(pageIndex, pageSize, title);
            r.setData(articleList);
        });
    }
}
