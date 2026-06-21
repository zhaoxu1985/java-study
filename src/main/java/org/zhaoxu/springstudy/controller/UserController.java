package org.zhaoxu.springstudy.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.zhaoxu.springstudy.common.result.Result;
import org.zhaoxu.springstudy.entity.User;
import org.zhaoxu.springstudy.service.UserService;
import java.util.List;

@RestController // 接口控制器，返回 JSON
@RequestMapping("/api/users") // 统一接口前缀，规范接口路径
public class UserController {

    // 注入业务类（Spring 自动管理）
    private final UserService userService;

    // 构造器注入（规范写法，推荐）
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /api/users - 获取所有用户
    @GetMapping
    public Result<List<User>> listUsers() {
        return Result.success(userService.listUsers());
    }

    // GET /api/users/{id} - 根据ID获取用户
    @GetMapping("/{id}")
    public Result<User> getUserById(@PathVariable Long id) {
        return Result.success(userService.getUserById(id));

    }

    // POST /api/users - 新增用户（示例）
    @PostMapping
    public Result<User> createUser(@Valid @RequestBody User user) {
        // 这里可以写新增逻辑，先直接返回传入的数据
        return Result.success(userService.addUser(user));
    }
}