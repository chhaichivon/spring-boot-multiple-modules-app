package com.chhaichivon.web.controller;

import com.chhaichivon.domain.ApiResponse;
import com.chhaichivon.domain.Article;
import com.chhaichivon.persistence.service.ArticleService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
@RestController
@RequestMapping(value = "/api/articles")
public class ArticleController extends ApiResponse<Article> implements BaseController<Article> {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "limit", defaultValue = "10") int limit) {
        List<Article> articles = articleService.findAll(page, limit);
        return response(articles);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Long id) {
        Article article = articleService.findOne(id);
        return response(article);
    }

    @Override
    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Article entity) {
        Article article = articleService.saveOrUpdate(entity);
        return response(article);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> Update(@PathVariable("id") Long id, @RequestBody Article entity) {
        Article article = articleService.saveOrUpdate(entity);
        return response(article);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        Article article = articleService.delete(id);
        return response(article);
    }
}
