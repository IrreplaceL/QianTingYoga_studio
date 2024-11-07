package com.qianting.yoga.studio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.domian.vo.UserVo;
import com.qianting.yoga.studio.enums.AppHttpCodeEnum;
import com.qianting.yoga.studio.exception.SystemException;
import com.qianting.yoga.studio.mapper.UserMapper;
import com.qianting.yoga.studio.service.UserService;
import com.qianting.yoga.studio.utils.BeanCopyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qianting.yoga.studio.domian.entity.User;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;


/**
 * 用户表，存储系统中的用户信息(User)表服务实现类
 *
 * @author makejava
 * @since 2024-10-27 19:46:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseResult userInformationList() {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //按照用户id升序排列
        queryWrapper.orderByAsc(User::getUserId);
        Page<User> page = new Page(1,10);
        page(page,queryWrapper);
        //封装响应
        List<User> users = page.getRecords();
        //利用工具类
        List<UserVo> articleVos =
                BeanCopyUtils.copyBeanList(users, UserVo.class);
        return ResponseResult.successResult(articleVos);


    }

    @Override
    public ResponseResult updataUserInformation(UserVo userVo) {
        User user = BeanCopyUtils.copyBean(userVo,User.class);
        user.setUpdateTime(new Date());
        updateById(user);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult register(UserVo userVo) {
        //对数据是否非空进行判断
        if (!StringUtils.hasText(userVo.getUsername()))
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        if (!StringUtils.hasText(userVo.getPassword()))
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        if (!StringUtils.hasText(userVo.getAvatar()))
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        if (!StringUtils.hasText(userVo.getPhone()))
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        if (!StringUtils.hasText(userVo.getGender()))
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        if (userVo.getIdentity() == null)
            throw new SystemException(AppHttpCodeEnum.USERNAME_NOT_NULL);
        // todo 对数据是否存在判断
        // todo 密码加密
        User user = BeanCopyUtils.copyBean(userVo, User.class);
        user.setUpdateTime(new Date());
        user.setCreateTime(new Date());
        save(user);
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult updataCourse(User user) {
        if(user.getUserId() == null){
            user.setCreateTime(new Date());
            user.setUpdateTime(new Date());
            save(user);
        }else {
            updateById(user);
            user.setUpdateTime(new Date());
        }
        return ResponseResult.successResult();
    }

    @Override
    public ResponseResult deleteUser(User user) {
        userMapper.deleteById(user.getUserId());
       return ResponseResult.successResult();
    }


    // todo jwt与用户授权登陆，好像应该不在这里
    // todo 自动填充字符段

}
