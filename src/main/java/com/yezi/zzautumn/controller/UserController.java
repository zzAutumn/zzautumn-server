package com.yezi.zzautumn.controller;

import com.yezi.zzautumn.domain.User;
import com.yezi.zzautumn.service.UserService;
import com.yezi.zzautumn.utils.OperationResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yezi
 * @Date: 2019/1/12 13 31
 * @Description:
 */
@Api(value = "用户管理", description = "用户管理")
@RestController
@RequestMapping("/zzautumn/v1/user")
public class UserController extends BaseController{

    @Autowired
    UserService userService;

    @RequestMapping(value = "/check-user", method = {RequestMethod.POST})
    @ApiOperation(value = "验证用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query"),
    })
    public OperationResult checkUser(String name, String password) {
        return processSimple((r) -> {
            Object res = userService.checkUser(name, password);
            r.setData(res);
        });
    }

    @RequestMapping(value = "/add-user", method = {RequestMethod.POST})
    @ApiOperation(value = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用户名", required = true, paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, paramType = "query"),
    })
    public OperationResult addUser(String name, String password) {
        return processSimple((r) -> {
            User user = userService.addUser(name, password);
            r.setData(user);
        });
    }
}
