package com.chhaichivon.persistence.repository;

import com.chhaichivon.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {
}