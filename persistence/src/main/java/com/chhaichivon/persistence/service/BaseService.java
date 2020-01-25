package com.chhaichivon.persistence.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
public interface BaseService<T> {

    List<T> findAll(int page, int limit);

    T findOne(Long id);

    T saveOrUpdate(T entity);

    T delete(Long id);

    boolean exists(Long id);
}
