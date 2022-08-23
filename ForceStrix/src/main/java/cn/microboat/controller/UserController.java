package cn.microboat.controller;

import cn.microboat.feign.UserService;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhouwei
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @SneakyThrows
    @GetMapping("/hi")
    public String getUser() {
        return userService.hi();
    }

    @SneakyThrows
    @GetMapping("/show")
    public boolean showUser() {
        return userService.show();
    }

    @SneakyThrows
    @GetMapping("/hi2/{name}")
    public String hi2(@PathVariable("name") String name) {
        return userService.hi2(name);
    }
}
