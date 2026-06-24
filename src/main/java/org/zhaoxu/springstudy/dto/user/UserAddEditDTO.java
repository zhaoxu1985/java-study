package org.zhaoxu.springstudy.dto.user;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.zhaoxu.springstudy.entity.user.UserGroup;

@Data
public class UserAddEditDTO {
    @Null(message = "新增操作不能传入ID", groups = UserGroup.Add.class)
    @NotNull(message = "用户ID不能为空", groups = UserGroup.Edit.class)
    private Long id;

    @NotBlank(message = "用户名不能为空", groups = {UserGroup.Edit.class, UserGroup.Add.class})
    private String username;

    @Min(value=1, message = "年龄不能小于1")
    @Max(value = 150, message = "年龄不能大于150")
    @NotNull(message = "年龄不能为空", groups = UserGroup.Add.class)
    private Integer age;
}