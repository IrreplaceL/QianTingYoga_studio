package com.qianting.yoga.studio.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.repository.IRepository;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.domian.entity.User;
import com.qianting.yoga.studio.domian.vo.UserVo;

/**
 * 用户表，存储系统中的用户信息(User)表服务接口
 *
 * @author makejava
 * @since 2024-10-27 19:46:38
 */
public interface UserService extends IService<User> {
    ResponseResult userInformationList();

    ResponseResult updataUserInformation(UserVo user);

    ResponseResult register(UserVo user);

    ResponseResult updataCourse(User user);

    ResponseResult deleteUser(User user);

    ResponseResult userInformationById(Integer id);

    ResponseResult userLgin(UserVo user);

    ResponseResult userInformationByUsername(String username);
}
