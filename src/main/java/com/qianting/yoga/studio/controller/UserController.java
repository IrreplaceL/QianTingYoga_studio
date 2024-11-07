package com.qianting.yoga.studio.controller;


import com.qianting.yoga.studio.domian.entity.Course;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.domian.entity.User;
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

    /**
     * 更新和新增用户，管理员，用户，教师走该接口
     * @param user 传参方式同课程表一样
     * @return
     */
    @PostMapping("/updataUser")
    public ResponseResult updataUser(@RequestBody User user){
        return userService.updataCourse(user);
    }

    /**
     * 根据id删除用户信息
     * @param user
     * @return
     */
    @PostMapping("/deleteUser")
    public ResponseResult deleteUser(@RequestBody User user){
        return userService.deleteUser(user);
    }

    /**
     * 根据id查找用户信息
     * @param id
     * @return
     */
    @GetMapping("/userInformationById/{id}")
    public ResponseResult userInformationById(@PathVariable Integer id){
        return userService.userInformationById(id);
    }

    /**
     * 用户登陆接口
     * @param user
     * @return
     */
    @PostMapping("/userlogin")
    public ResponseResult userLogin(@RequestBody UserVo user){
        return userService.userLgin(user);
    }
}

