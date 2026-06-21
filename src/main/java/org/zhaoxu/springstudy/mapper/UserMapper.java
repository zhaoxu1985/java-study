package org.zhaoxu.springstudy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.zhaoxu.springstudy.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 继承 BaseMapper 自带 CRUD 方法，不用写代码
}