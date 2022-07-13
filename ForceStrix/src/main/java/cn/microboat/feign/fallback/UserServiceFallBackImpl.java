package cn.microboat.feign.fallback;

import cn.microboat.feign.UserService;

/**
 * @author zhouwei
 */
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
