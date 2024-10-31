package com.qianting.yoga.studio.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianting.yoga.studio.domian.entity.ResponseResult;
import com.qianting.yoga.studio.domian.vo.UserVo;
import com.qianting.yoga.studio.mapper.UserMapper;
import com.qianting.yoga.studio.service.UserService;
import com.qianting.yoga.studio.utils.BeanCopyUtils;
import org.springframework.stereotype.Service;
import com.qianting.yoga.studio.domian.entity.User;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static com.baomidou.mybatisplus.extension.toolkit.Db.page;

/**
 * 用户表，存储系统中的用户信息(User)表服务实现类
 *
 * @author makejava
 * @since 2024-10-27 19:46:38
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
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
}
