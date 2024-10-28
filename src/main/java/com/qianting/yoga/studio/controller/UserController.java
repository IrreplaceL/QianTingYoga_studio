package com.qianting.yoga.studio.controller;



import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户表，存储系统中的用户信息(User)表控制层
 *
 * @author makejava
 * @since 2024-10-27 18:25:58
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController  {

    @Autowired
    private UserService userService;

    @GetMapping("/userInformationList")
    public ResponseResult userInformationList(){
        log.info("执行该方法");
        ResponseResult result = userService.userInformationList();
        return result;
        }
}

