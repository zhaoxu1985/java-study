package org.zhaoxu.springstudy.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.zhaoxu.springstudy.dto.user.UserAddDTO;
import org.zhaoxu.springstudy.dto.user.UserEditDTO;
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
        return Result.success(userService.getUserById(id));
    }

    // 新增接口
    @PostMapping("/add")
    public Result<UserVO> addUser(@Validated(UserGroup.Add.class) @RequestBody UserAddDTO dto){
        return Result.success(userService.addUser(dto));
    }

    // 编辑接口
    @PostMapping("/edit")
    public Result<UserVO> updateUser(@Validated(UserGroup.Edit.class) @RequestBody UserEditDTO dto){
        return Result.success(userService.updateUser(dto));
    }

    // 用户分页列表
    @PostMapping("/list")
    public Result<PageResultVO<UserVO>> page(@RequestBody UserQueryDTO query) {
        // Service 直接返回 PageResultVO，无需二次转换
        PageResultVO<UserVO> pageResult = userService.pageUser(query);
        return Result.success(pageResult);
    }
}