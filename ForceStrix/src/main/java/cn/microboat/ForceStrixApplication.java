package cn.microboat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhouwei
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "cn.microboat.feign")
public class ForceStrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForceStrixApplication.class, args);
    }
}
