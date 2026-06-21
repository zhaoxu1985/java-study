package org.zhaoxu.springstudy.service;

import org.zhaoxu.springstudy.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface UserService extends IService<User> {
    List<User> listUsers();
    User getUserById(Long id);
    User addUser(User user);
}