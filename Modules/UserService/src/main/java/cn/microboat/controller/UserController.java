package cn.microboat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 */
@RestController
@RequestMapping("/user")
@RefreshScope
@Api(value = "用户接口")
public class UserController {

    @Value("${user.showUser}")
    private boolean showUser;

    @ApiOperation(value = "/show", notes = "显示用户", httpMethod = "GET")
    @GetMapping("/show")
    public boolean showUser() {
        return showUser;
    }

    @ApiOperation(value = "/hi", notes = "打招呼", httpMethod = "GET")
    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @ApiOperation(value = "/hi2/{name}", notes = "用名称打招呼", httpMethod = "GET")
    @GetMapping("/hi2/{name}")
    public String hi2(@ApiParam(value = "name") @PathVariable("name") String name) {
        return "Hi, I'm " + name + ", nice to meet you!";
    }

}
