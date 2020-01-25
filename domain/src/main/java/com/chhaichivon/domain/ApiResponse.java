package com.chhaichivon.domain;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Chhai Chivon
 * Date     : 1/1/20, 1:54 PM
 * Email    : chhai.chivon@prasac.com.kh
 */
public abstract class ApiResponse<T> {

    public Map<String, Object> map;
    private  static String SUCCESS = "success";
    private static String FAIL  = "fail";

  public ResponseEntity<Map<String , Object>> response(Page<T> page){
        if(page.hasContent()){
            return new ResponseEntity<>(onSuccess(page,null,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(onFail(),HttpStatus.OK);
    }

    public  ResponseEntity<Map<String , Object>> response(T entity){
        if(entity != null){
            return new ResponseEntity<>(onSuccess(null,null,entity), HttpStatus.OK);
        }
        return new ResponseEntity<>(onFail(),HttpStatus.OK);
    }

    public ResponseEntity<Map<String , Object>> response(List<T> list){
        if(list != null){
            return new ResponseEntity<>(onSuccess(null,list,null), HttpStatus.OK);
        }
        return new ResponseEntity<>(onFail(),HttpStatus.OK);
    }

    private Map<String , Object> onSuccess(Page<T> page, List<T> list, T entity){
        map = new HashMap<>();
        if(page != null && page.hasContent()){
            map.put("data",page);
            map.put("message",SUCCESS);
            map.put("status",200);
        }else if(list != null){
            map.put("data",list);
            map.put("message",SUCCESS);
            map.put("status",200);
        }else if(entity !=  null){
            map.put("data",entity);
            map.put("message",SUCCESS);
            map.put("status",200);
        }
        return map;
    }
    private Map<String , Object> onFail(){
        map = new HashMap<>();
        map.put("message",FAIL);
        map.put("status",400);
        return map;
    }
}