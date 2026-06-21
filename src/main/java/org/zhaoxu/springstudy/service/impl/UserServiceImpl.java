package org.zhaoxu.springstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.zhaoxu.springstudy.DTO.user.UserAddDTO;
import org.zhaoxu.springstudy.DTO.user.UserEditDTO;
import org.zhaoxu.springstudy.DTO.user.UserQueryDTO;
import org.zhaoxu.springstudy.common.enums.business.UserCode;
import org.zhaoxu.springstudy.common.exception.BusinessException;
import org.zhaoxu.springstudy.entity.user.User;
import org.zhaoxu.springstudy.mapper.UserMapper;
import org.zhaoxu.springstudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

@Service // 交给 Spring 管理的业务类
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    // 先模拟数据，后续加数据库再替换
    @Override
    public List<User> listUsers() {
        User u1 = new User();
        u1.setId(1L);
        u1.setUsername("张三");
        u1.setAge(20);

        User u2 = new User();
        u2.setId(2L);
        u2.setUsername("李四");
        u2.setAge(22);

        return List.of(u1, u2);
    }

    @Override
    public User getUserById(Long id) {
        User user = new User();
        user.setId(id);
        user.setUsername("测试用户");
        user.setAge(18);
        return user;
    }

    @Override
    public User addUser(UserAddDTO user) {
        // 校验用户名重复
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername());
        if (this.getOne(wrapper) != null) {
            throw new BusinessException(UserCode.USERNAME_EXIST);
        }
        // 新增：MP自动生成雪花ID
        this.save(user);
        return user;
    }

    @Override
    public User updateUser(UserEditDTO user) {
        // 校验用户名重复：排除当前自身ID
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, user.getUsername())
                .ne(User::getId, user.getId());

        if (this.getOne(wrapper) != null) {
            throw new BusinessException(UserCode.USER_NOT_EXIST);
        }
        // 根据ID更新
        this.updateById(user);
        return user;
    }

    @Override
    public IPage<User> pageUser(UserQueryDTO query) {
        // 1. 构建分页对象：参数(当前页, 每页条数)
        Page<User> page = new Page<>(query.getPageNum(), query.getPageSize());

        // 2. 构建动态查询条件
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        // 用户名模糊查询：不为空才拼接条件
        if (StringUtils.hasText(query.getUsername())) {
            wrapper.like(User::getUsername, query.getUsername());
        }
        // 年龄精准查询：不为null才拼接
        if (query.getAge() != null) {
            wrapper.eq(User::getAge, query.getAge());
        }
        // 根据id精准查询
        if(query.getId() != null){
            wrapper.eq(User::getId, query.getId());
        }
        // 逻辑删除 MP 已自动过滤 deleted=1 的数据，无需手动处理

        // 3. 执行分页查询，返回分页结果
        return this.page(page, wrapper);
    }
}