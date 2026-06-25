package org.zhaoxu.springstudy.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.zhaoxu.springstudy.dto.user.UserAddEditDTO;
import org.zhaoxu.springstudy.dto.user.UserDeleteDTO;
import org.zhaoxu.springstudy.entity.user.User;
import org.zhaoxu.springstudy.vo.user.UserVO;

import java.util.List;

/**
 * 用户对象转换器
 * MapStruct 编译时自动生成实现类
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    /**
     * UserAddEditDTO → User
     * 无需额外@Mapping，不存在的字段会自动忽略
     */
    User toEntity(UserAddEditDTO dto);
    User toEntity(UserDeleteDTO dto);

    /**
     * UserEditDTO 更新到已有 User 对象（局部更新）
     * 不存在的字段不会覆盖原有值
     */
    void updateEntityFromDTO(UserAddEditDTO dto, @MappingTarget User entity);
    void updateEntityFromDTO(UserDeleteDTO dto, @MappingTarget User entity);

    /**
     * User Entity → UserVO
     */
    UserVO toVO(User entity);

    // 关键：Entity List → VO List
    List<UserVO> toVOList(List<User> entityList);
}