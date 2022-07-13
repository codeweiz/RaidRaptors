package cn.microboat.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhouwei
 */
@FeignClient("raid-raptor-service-provider")
public interface UserService {

    /**
     * user 服务，获取 hi
     *
     * @return String
     */
    @GetMapping("/user/hi")
    String hi();

    /**
     * user 服务，获取 show
     *
     * @return boolean
     */
    @GetMapping("/user/show")
    boolean show();

    /**
     * user 服务，获取 hi2
     *
     * @param name 名称
     * @return String
     */
    @GetMapping("/user/hi2/{name}")
    String hi2(@PathVariable("name") String name);
}
