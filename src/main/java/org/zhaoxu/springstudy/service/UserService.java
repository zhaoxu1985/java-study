package org.zhaoxu.springstudy.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.zhaoxu.springstudy.dto.user.UserAddDTO;
import org.zhaoxu.springstudy.dto.user.UserEditDTO;
import org.zhaoxu.springstudy.dto.user.UserQueryDTO;
import org.zhaoxu.springstudy.vo.PageResultVO;
import org.zhaoxu.springstudy.vo.user.UserVO;
import org.zhaoxu.springstudy.entity.user.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * 用户服务接口
 * 返回类型使用 VO（视图对象），避免直接暴露实体
 */
public interface UserService extends IService<User> {
    /**
     * 获取所有用户列表
     * @return 用户VO列表
     */
    List<UserVO> listUsers();

    /**
     * 根据ID获取用户
     * @param id 用户ID
     * @return 用户VO
     */
    UserVO getUserById(Long id);

    /**
     * 新增用户
     * @param dto 用户新增DTO
     * @return 用户VO
     */
    UserVO addUser(UserAddDTO dto);

    /**
     * 编辑用户
     * @param dto 用户编辑DTO
     * @return 用户VO
     */
    UserVO updateUser(UserEditDTO dto);

    /**
     * 分页查询用户
     * @param query 查询条件
     * @return 用户VO分页结果
     */
    PageResultVO<UserVO> pageUser(UserQueryDTO query);
}