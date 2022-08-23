package cn.microboat.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 */
@Api(value = "/person", tags = "人员api")
@RestController
@RefreshScope
@RequestMapping("/person")
public class PersonController {

    @ApiOperation(value = "/get", notes = "获取人员接口", httpMethod = "GET")
    @GetMapping("/get")
    public String getPerson() {
        return "get person";
    }
}
