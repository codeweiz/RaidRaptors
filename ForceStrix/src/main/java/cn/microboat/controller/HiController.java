package cn.microboat.controller;

import cn.microboat.utils.ThreadUtils;
import lombok.SneakyThrows;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zhouwei
 */
@RestController
@RequestMapping("/hi")
public class HiController {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @SneakyThrows
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getFromServiceProvider() {
        return ThreadUtils.THREAD_POOL.submit(() -> restTemplate.getForObject("http://raid-raptor-service-provider/user/hi", String.class)).get();
    }

    @RequestMapping(value = "/hi2", method = RequestMethod.GET)
    public String hi2() {
        return "hi2";
    }
}
