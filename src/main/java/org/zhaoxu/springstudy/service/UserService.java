package org.zhaoxu.springstudy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.zhaoxu.springstudy.DTO.user.UserAddDTO;
import org.zhaoxu.springstudy.DTO.user.UserEditDTO;
import org.zhaoxu.springstudy.DTO.user.UserQueryDTO;
import org.zhaoxu.springstudy.entity.user.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

public interface UserService extends IService<User> {
    List<User> listUsers();
    User getUserById(Long id);
    // 新增用户
    User addUser(UserAddDTO user);
    // 编辑用户
    User updateUser(UserEditDTO user);
    // 新增：分页查询
    IPage<User> pageUser(UserQueryDTO query);
}