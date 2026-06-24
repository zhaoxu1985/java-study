package org.zhaoxu.springstudy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.zhaoxu.springstudy.dto.user.UserDeleteDTO;
import org.zhaoxu.springstudy.mapstruct.UserConverter;
import org.zhaoxu.springstudy.mapstruct.PageConverter;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.zhaoxu.springstudy.dto.user.UserAddEditDTO;
import org.zhaoxu.springstudy.dto.user.UserQueryDTO;
import org.zhaoxu.springstudy.vo.PageResultVO;
import org.zhaoxu.springstudy.vo.user.UserVO;
import org.zhaoxu.springstudy.common.enums.business.UserCode;
import org.zhaoxu.springstudy.common.exception.BusinessException;
import org.zhaoxu.springstudy.entity.user.User;
import org.zhaoxu.springstudy.mapper.UserMapper;

import org.zhaoxu.springstudy.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private  UserConverter userConverter;
    @Autowired
    private  PageConverter pageConverter;

//    // 构造器注入，无需 @Autowired
//    public UserServiceImpl(UserConverter userConverter, PageConverter pageConverter) {
//        this.userConverter = userConverter;
//        this.pageConverter = pageConverter;
//    }

    @Override
    public List<UserVO> listUsers() {
        List<User> users = this.list();
        return users.stream()
                .map(userConverter::toVO)
                .collect(Collectors.toList());
    }

    @Override
    public UserVO getUserById(Long id) {
        User user = this.getById(id);
        if (user == null) {
            throw new BusinessException(UserCode.USER_NOT_EXIST);
        }
        return userConverter.toVO(user);
    }

    @Override
    public UserVO addUser(UserAddEditDTO dto) {
        // 校验用户名重复
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, dto.getUsername());
        if (this.getOne(wrapper) != null) {
            throw new BusinessException(UserCode.USERNAME_EXIST);
        }

        // 使用 MapStruct 将 DTO 转换为 Entity
        User user = userConverter.toEntity(dto);
        user.setId(null);
        // 保存实体
        this.save(user);

        // 转换为 VO 返回
        return userConverter.toVO(user);
    }

    @Override
    public UserVO updateUser(UserAddEditDTO dto) {
        // 1. 根据ID查询用户
        User user = this.getById(dto.getId());
        if (user == null) {
            throw new BusinessException(UserCode.USER_NOT_EXIST);
        }

        // 2. MapStruct 局部更新对象
        userConverter.updateEntityFromDTO(dto, user);
        // 3. 执行数据库更新
        this.updateById(user);

        return userConverter.toVO(user);
    }

    @Override
    public UserVO deleteUser(UserDeleteDTO dto) {
        // 1. 根据ID查询用户
        User user = this.getById(dto.getId());
        if (user == null) {
            throw new BusinessException(UserCode.USER_NOT_EXIST);
        }

        // 2. MapStruct 局部更新对象
        userConverter.updateEntityFromDTO(dto, user);
        // 3. 执行数据库更新
        this.removeById(user);

        return userConverter.toVO(user);
    }

    @Override
    public PageResultVO<UserVO> pageUser(UserQueryDTO query){
        // 1. 构建分页对象
        Page<User> page = new Page<>(query.getPageNum(), query.getPageSize());
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();

        // 2. 拼接查询条件
        if (StringUtils.hasText(query.getUsername())) {
            wrapper.like(User::getUsername, query.getUsername());
        }
        if (query.getAge() != null) {
            wrapper.eq(User::getAge, query.getAge());
        }
        if (query.getId() != null) {
            wrapper.eq(User::getId, query.getId());
        }

        // 3. 执行分页查询
        IPage<User> userPage = this.page(page, wrapper);

        // 4. 关键：先把 Entity List 转为 VO List，再用 PageConverter 组装
        List<UserVO> voList = userConverter.toVOList(userPage.getRecords());
        return pageConverter.toPageVO(userPage, voList);
    }
}