package com.chhaichivon.persistence.service;

import com.chhaichivon.domain.Article;
import com.chhaichivon.persistence.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
@Service
public class ArticleService implements BaseService<Article> {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> findAll(int page, int limit) {
        return articleRepository.findAll();
    }

    @Override
    public Article findOne(Long id) {
        Article article = new Article();
        if(articleRepository.findById(id).isPresent()){
            article = articleRepository.findById(id).get();
        }
        return article;
    }

    @Override
    public Article saveOrUpdate(Article entity) {
        return articleRepository.save(entity);
    }

    @Override
    public Article delete(Long id) {
        Article article = findOne(id);
        if(article != null){
            articleRepository.delete(article);
        }
        return article;
    }

    @Override
    public boolean exists(Long id) {
        return articleRepository.existsById(id);
    }
}
