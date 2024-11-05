package com.qianting.yoga.studio.controller;


import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.domian.vo.UserVo;
import com.qianting.yoga.studio.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 *
 * 用户
 * @author makejava
 * @since 2024-10-27 18:25:58
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController  {

    @Autowired
    private UserService userService;

    /**
     * 获取全部用户数据，按照userId升序排列
     * @return
     */
    @GetMapping("/userInformationList")
    public ResponseResult userInformationList(){
        log.info("执行该方法");
        ResponseResult result = userService.userInformationList();
        return result;
        }

    /**
     * 更新用户数据
      * @param user 用户实体类
     * @return
     */
    @PostMapping("/updataUserInformation")
    public ResponseResult updataUserInformation(@RequestBody UserVo user){
        return userService.updataUserInformation(user);
    }

    /**
     * 用户注册
     * @param user 不允许传用户id，该属性由数据库自增完成
     * @return
     */
    @PostMapping("/register")
    public ResponseResult register(@RequestBody UserVo user){
       return userService.register(user);

    }
}

