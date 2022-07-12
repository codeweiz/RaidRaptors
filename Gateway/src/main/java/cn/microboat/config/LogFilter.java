package cn.microboat.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhouwei
 */
@Component
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        String token = ((RequestFacade) servletRequest).getHeader("token");
        if (ObjectUtils.isEmpty(token)) {
            log.error("token is empty");
            return;
        }
        if ("admin".equals(token)) {
            try {
                filterChain.doFilter(servletRequest, servletResponse);
            } catch (IOException | ServletException e) {
                log.error(e.toString());
            }
        }
    }
}
