package cn.microboat.controller;

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
public class UserController {

    @Value("${user.showUser}")
    private boolean showUser;

    @GetMapping("/show")
    public boolean showUser() {
        return showUser;
    }

    @GetMapping("/hi")
    public String hi() {
        return "hi";
    }

    @GetMapping("/hi2/{name}")
    public String hi2(@PathVariable("name") String name) {
        return "Hi, I'm " + name + ", nice to meet you!";
    }

}
