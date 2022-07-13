package cn.microboat.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 */
@RestController
@RefreshScope
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/get")
    public String getPerson() {
        return "get person";
    }
}
