package com.yezi.zzautumn.repository;

import com.yezi.zzautumn.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author: yezi
 * @Date: 2019/1/6 15 19
 * @Description:
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Page<Article> findArticlesByTitleIsLikeAndDeletedIsFalse(String title, Pageable pageable);

    Optional<Article> findByIdAndDeletedIsFalse(Integer integer);
}
