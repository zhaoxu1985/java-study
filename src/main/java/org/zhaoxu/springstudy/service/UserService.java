package org.zhaoxu.springstudy.service;

import org.springframework.stereotype.Component;
import org.zhaoxu.springstudy.dto.user.UserAddEditDTO;
import org.zhaoxu.springstudy.dto.user.UserDeleteDTO;
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

@Component
public interface UserService {
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
    UserVO addUser(UserAddEditDTO dto);

    /**
     * 编辑用户
     * @param dto 用户编辑DTO
     * @return 用户VO
     */
    UserVO updateUser(UserAddEditDTO dto);

    /**
     * 删除用户
     */
    UserVO deleteUser(UserDeleteDTO dto);
    boolean batchDeleteUser(UserDeleteDTO dto);

    /**
     * 分页查询用户
     * @param query 查询条件
     * @return 用户VO分页结果
     */
    PageResultVO<UserVO> pageUser(UserQueryDTO query);
}