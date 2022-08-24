package cn.microboat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhouwei
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {
    public static void main(String[] args) {
        try {
            log.info(InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            log.info("exception class: {}, exception message: {}", e.getClass(), e.getMessage());
        }
        SpringApplication.run(GatewayApplication.class, args);
    }
}
