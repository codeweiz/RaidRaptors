package cn.microboat.feign.fallback;

import cn.microboat.feign.UserService;
import org.springframework.stereotype.Component;

/**
 * @author zhouwei
 */
@Component
public class UserServiceFallBackImpl implements UserService {
    @Override
    public String hi() {
        return "service maybe broken...";
    }

    @Override
    public boolean show() {
        return false;
    }

    @Override
    public String hi2(String name) {
        return "service maybe broken...";
    }
}
