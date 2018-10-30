package com.example.demo.service.iservice;

import com.example.demo.mappers.UserMapper;
import com.example.demo.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @ClassName IUserService
 * @Description TODD
 * @Author Administrator
 * @Date 2018/10/29 0029 下午 4:41
 * @Version 1.0
 **/
@Service
public class IUserService  implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String,String>> getUser() {
        PageHelper pageHelper = new PageHelper();
        PageHelper.startPage(0,10);
        return userMapper.getUser(1);

    }
}
