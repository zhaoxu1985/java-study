package org.zhaoxu.springstudy.entity.user;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@TableName("user") // 对应数据库表名1
public class User {

    @TableId(type = IdType.ASSIGN_ID) // 自增主键
    @Null(message = "新增操作不能传入ID", groups = UserGroup.Add.class)
    @NotNull(message = "编辑操作必须传入ID", groups = UserGroup.Edit.class)
    private Long id;

    @NotBlank(message = "用户名不能为空", groups = {UserGroup.Add.class, UserGroup.Edit.class})
    private String username;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    // 创建时间，自动填充
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    // 更新时间，插入+更新都自动填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    // 逻辑删除字段
    @TableLogic
    private Integer deleted;
}