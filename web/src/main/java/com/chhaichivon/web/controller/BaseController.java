package com.chhaichivon.web.controller;

import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
public interface BaseController<T> {

    ResponseEntity<Map<String,Object>> findAll(int page, int limit);

    ResponseEntity<Map<String,Object>> findById(Long id);

    ResponseEntity<Map<String,Object>> save(T entity);

    ResponseEntity<Map<String,Object>> Update(Long id, T entity);

    ResponseEntity<Map<String,Object>> delete(Long id);
}