package org.zhaoxu.springstudy.entity.user;

import com.baomidou.mybatisplus.annotation.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;


@Data
@TableName("user") // 对应数据库表名1
public class User {

    @TableId(type = IdType.ASSIGN_ID) // 自增主键
    private Long id;

    private String username;

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