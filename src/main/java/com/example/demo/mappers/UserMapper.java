package com.example.demo.mappers;

import java.util.List;
import java.util.Map;

/**
 * @ClassName UserMapper
 * @Description TODD
 * @Author Administrator
 * @Date 2018/10/29 0029 下午 4:38
 * @Version 1.0
 **/
public interface UserMapper {
    public List<Map<String,String>> getUser(Integer args);
}
