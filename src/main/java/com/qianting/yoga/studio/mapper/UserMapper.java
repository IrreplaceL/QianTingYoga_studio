package com.qianting.yoga.studio.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qianting.yoga.studio.domian.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表，存储系统中的用户信息(User)表数据库访问层
 *
 * @author makejava
 * @since 2024-10-27 18:25:59
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
