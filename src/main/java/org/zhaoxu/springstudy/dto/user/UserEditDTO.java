package org.zhaoxu.springstudy.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.zhaoxu.springstudy.entity.user.UserGroup;

@Data
public class UserEditDTO {
    @NotNull(message = "用户ID不能为空", groups = UserGroup.Edit.class)
    private Long id;

    @NotBlank(message = "用户名不能为空", groups = UserGroup.Edit.class)
    private String username;

    @NotNull(message = "年龄不能为空")
    private Integer age;
}