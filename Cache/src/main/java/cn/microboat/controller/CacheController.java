package cn.microboat.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouwei
 */
@RestController
@RequestMapping("/cache")
public class CacheController {

    @Cacheable(value = {"test"}, key = "#root.method.name")
    @GetMapping("/test")
    public String test() {
        return "123456";
    }
}
