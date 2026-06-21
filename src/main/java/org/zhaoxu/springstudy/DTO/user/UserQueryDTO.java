package org.zhaoxu.springstudy.DTO.user;

import lombok.Data;

@Data
public class UserQueryDTO {
    // 当前页码，默认第1页
    private Long pageNum = 1L;
    // 每页条数，默认10条
    private Long pageSize = 10L;
    // 用户名模糊查询
    private String username;
    // 年龄查询（可扩展区间）
    private Integer age;
    // 根据ID查询
    private Long id;
}