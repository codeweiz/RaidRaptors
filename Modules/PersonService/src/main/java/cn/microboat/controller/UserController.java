package cn.microboat.controller;

import cn.microboat.feign.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouwei
 */
@Api(value = "feign", tags = "远程调用 userService")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "/hi", notes = "打招呼", httpMethod = "GET")
    @GetMapping("/hi")
    public String getUser() {
        return userService.hi();
    }

    @ApiOperation(value = "/show", notes = "展示", httpMethod = "GET")
    @GetMapping("/show")
    public boolean showUser() {
        return userService.show();
    }

    @ApiOperation(value = "/hi2/{name}", notes = "带名称打招呼", httpMethod = "GET")
    @GetMapping("/hi2/{name}")
    public String hi2(@ApiParam(value = "name") @PathVariable("name") String name) {
        return userService.hi2(name);
    }
}
