package org.zhaoxu.springstudy.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.zhaoxu.springstudy.entity.user.UserGroup;

@Data
public class UserDeleteDTO {
    @NotNull(message = "用户ID不能为空", groups = UserGroup.Delete.class)
    private Long id;

    @NotNull(message = "用户ids不能为空", groups = UserGroup.BatchDelete.class)
    @Size(message = "ids长度为空", min = 1, groups = UserGroup.BatchDelete.class)
    private Long[] ids;
}