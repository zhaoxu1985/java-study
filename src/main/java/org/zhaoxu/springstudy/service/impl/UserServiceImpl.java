package org.zhaoxu.springstudy.service.impl;

import org.springframework.stereotype.Service;
import org.zhaoxu.springstudy.entity.User;
import org.zhaoxu.springstudy.mapper.UserMapper;
import org.zhaoxu.springstudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
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
    public User addUser(User user) {
        // 调用 MP 自带新增方法，真正插入数据库
        this.save(user);
        return user;
    }
}