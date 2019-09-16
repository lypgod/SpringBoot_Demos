package com.lypgod.springboot.demo.cache;

import com.lypgod.springboot.demo.cache.user.User;
import com.lypgod.springboot.demo.cache.user.UserService;
import com.lypgod.springboot.demo.cache.util.RestResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author lypgod
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("/add")
    public RestResponse addUser(@Valid @RequestBody User user) {
        userService.insert(user);
        return new RestResponse().setRespCode("01").setRespMsg("新增成功").setData(userService.getUserById(user.getId()));
    }

    @PostMapping("/update")
    public RestResponse updateUser(@Valid @RequestBody User user) {
        userService.update(user);
        return new RestResponse().setRespCode("01").setRespMsg("更新成功").setData(userService.getUserById(user.getId()));
    }

    @GetMapping("/get/{id}")
    public RestResponse getUser(@PathVariable("id") Long id) {
        User user = userService.getUserById(id);
        return new RestResponse().setRespCode("01").setRespMsg("查询成功").setData(user);
    }

    @DeleteMapping("/deleteAll")
    public RestResponse deleteAllUsers() {
        userService.deleteAllUsers();
        return new RestResponse().setRespCode("01").setRespMsg("全部用户删除成功");
    }

    @DeleteMapping("/delete/{id}")
    public RestResponse deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new RestResponse().setRespCode("01").setRespMsg("用户删除成功");
    }

    @GetMapping("/page")
    public RestResponse getPagedUser(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable) {
        Page<User> userPage = userService.getPagedUser(pageable);
        return new RestResponse().setRespCode("01").setRespMsg("查询成功").setData(userPage);
    }
}