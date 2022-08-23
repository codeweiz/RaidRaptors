package cn.microboat.config;

import cn.microboat.Constants;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author zhouwei
 */
@Component
public class CustomFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // swagger 相关地址，放行
        if (StringUtils.endsWithIgnoreCase(exchange.getRequest().getPath().pathWithinApplication().toString(), "/v2/api-docs")) {
            return chain.filter(exchange);
        };

        HttpHeaders headers = exchange.getRequest().getHeaders();
        List<String> token = headers.get(Constants.TOKEN);
        if (ObjectUtils.isEmpty(token)) {
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        if (token.contains(Constants.ROLE_ADMIN)) {
            return chain.filter(exchange);
        }
        return exchange.getResponse().setComplete();
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
