package org.zhaoxu.springstudy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhaoxu.springstudy.DTO.user.UserAddDTO;
import org.zhaoxu.springstudy.DTO.user.UserEditDTO;
import org.zhaoxu.springstudy.DTO.user.UserQueryDTO;
import org.zhaoxu.springstudy.common.result.Result;
import org.zhaoxu.springstudy.common.util.PageUtil;
import org.zhaoxu.springstudy.common.vo.PageResultVO;
import org.zhaoxu.springstudy.entity.user.User;
import org.zhaoxu.springstudy.service.UserService;
import java.util.List;
import org.zhaoxu.springstudy.entity.user.UserGroup;


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

    // 新增接口
    @PostMapping("/add")
    public Result<User> addUser(@Validated(UserGroup.Add.class) @RequestBody UserAddDTO user){
        return Result.success(userService.addUser(user));
    }

    // 编辑接口
    @PostMapping("/edit")
    public Result<User> updateUser(@Validated(UserGroup.Edit.class) @RequestBody UserEditDTO user){
        return Result.success(userService.updateUser(user));
    }

    // 用户分页列表
    @PostMapping("/list")
    public Result<PageResultVO<User>> page(@RequestBody UserQueryDTO query) {
        IPage<User> page = userService.pageUser(query);
        PageResultVO<User> result = PageUtil.convert(page);
        return Result.success(result);
    }
}