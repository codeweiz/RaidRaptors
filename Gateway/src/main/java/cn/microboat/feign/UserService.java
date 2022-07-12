package cn.microboat.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhouwei
 */
@FeignClient("raid-raptor-service-provider")
public interface UserService {

    @GetMapping("/user/hi")
    String hi();
}
