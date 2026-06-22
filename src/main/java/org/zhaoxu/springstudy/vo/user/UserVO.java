package org.zhaoxu.springstudy.vo.user;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * 用户视图对象（用于接口返回）
 */
@Data
public class UserVO {
    /**
     * 用户ID
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}