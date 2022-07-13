package cn.microboat.controller;

import cn.microboat.feign.UserService;
import cn.microboat.utils.ThreadUtils;
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
        return ThreadUtils.THREAD_POOL.submit(() -> userService.hi()).get();
    }

    @SneakyThrows
    @GetMapping("/show")
    public boolean showUser() {
        return ThreadUtils.THREAD_POOL.submit(() -> userService.show()).get();
    }

    @SneakyThrows
    @GetMapping("/hi2/{name}")
    public String hi2(@PathVariable("name") String name) {
        return ThreadUtils.THREAD_POOL.submit(() -> userService.hi2(name)).get();
    }
}
