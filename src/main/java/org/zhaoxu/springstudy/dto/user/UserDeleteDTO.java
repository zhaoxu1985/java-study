package org.zhaoxu.springstudy.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.zhaoxu.springstudy.entity.user.UserGroup;

@Data
public class UserDeleteDTO {
    @NotNull(message = "用户ID不能为空", groups = UserGroup.Edit.class)
    private Long id;
}