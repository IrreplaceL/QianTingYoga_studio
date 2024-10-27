package com.qianting.yoga.studio.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qianting.yoga.studio.mapper.UserMapper;
import com.qianting.yoga.studio.service.UserService;
import com.qianting.yoga.studio.domian.entity.User;
import org.springframework.stereotype.Service;
/**
 * 用户表，存储系统中的用户信息(User)表服务实现类
 *
 * @author makejava
 * @since 2024-10-27 18:26:03
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
