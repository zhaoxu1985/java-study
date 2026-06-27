package org.zhaoxu.springstudy.controller;

import jakarta.validation.groups.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhaoxu.springstudy.dto.user.UserAddEditDTO;
import org.zhaoxu.springstudy.dto.user.UserDeleteDTO;
import org.zhaoxu.springstudy.dto.user.UserQueryDTO;
import org.zhaoxu.springstudy.vo.user.UserVO;
import org.zhaoxu.springstudy.common.result.Result;
import org.zhaoxu.springstudy.vo.PageResultVO;
import org.zhaoxu.springstudy.entity.user.UserGroup;
import org.zhaoxu.springstudy.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /api/users - 获取所有用户
    @GetMapping
    public Result<List<UserVO>> listUsers() {
        return Result.success(userService.listUsers());
    }

    // GET /api/users/{id} - 根据ID获取用户
    @GetMapping("/{id}")
    public Result<UserVO> getUserById(@PathVariable Long id) {
        UserVO vv = userService.getUserById(id);
        System.out.println("vv:"+vv);
        return Result.success(userService.getUserById(id));
    }

    // 新增接口
    @PostMapping("/add")
    public Result<UserVO> addUser(@Validated({UserGroup.Add.class, Default.class}) @RequestBody UserAddEditDTO dto){
        return Result.success(userService.addUser(dto));
    }

    // 编辑接口
    @PostMapping("/edit")
    public Result<UserVO> updateUser(@Validated(UserGroup.Edit.class) @RequestBody UserAddEditDTO dto){
        return Result.success(userService.updateUser(dto));
    }

    // 编辑接口
    @PostMapping("/delete")
    public Result<UserVO> deleteUser(@Validated(UserGroup.Delete.class) @RequestBody UserDeleteDTO dto){
        return Result.success(userService.deleteUser(dto));
    }

    @PostMapping("/delete-batch")
    public Result<Boolean> batchDeleteUser(@Validated(UserGroup.BatchDelete.class) @RequestBody UserDeleteDTO dto){
        return Result.success(userService.batchDeleteUser(dto));
    }



    // 用户分页列表
    @PostMapping("/list")
    public Result<PageResultVO<UserVO>> page(@RequestBody UserQueryDTO query) {
        // Service 直接返回 PageResultVO，无需二次转换
        PageResultVO<UserVO> pageResult = userService.pageUser(query);
        return Result.success(pageResult);
    }


}