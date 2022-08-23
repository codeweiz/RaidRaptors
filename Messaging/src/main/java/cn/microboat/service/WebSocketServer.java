package cn.microboat.service;

import cn.microboat.pojo.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouwei
 */
@Slf4j
@Component
@ServerEndpoint("/ws")
public class WebSocketServer {

    private static final Map<String, UserModel> MAP = new ConcurrentHashMap<>();

    @OnOpen
    public void onOpen(Session session) {
        MAP.put(session.getId(), UserModel.builder().session(session).build());
        log.info("客户端：{} 连接成功", session.getId());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        log.info("客户端：{} 消息：{}", session.getId(), message);
    }

    @OnClose
    public void onClose(Session session) {
        MAP.remove(session.getId());
        log.info("客户端：{} 断开连接", session.getId());
    }

    @OnError
    public void onError(Session session, Error error) {
        MAP.remove(session.getId());
        log.info("客户端：{} 连接异常，异常信息：{}，异常类：{}", session.getId(), error.getMessage(), error.getClass());
    }

    /**
     * 从 startId 发送消息 message 到 endId
     *
     * @param message 消息
     * @param startPoint 发送点
     * @param endPoint 接收点
     * */
    private void sendMessageFromStartToEnd(String message, String startPoint, String endPoint) {
        UserModel userModel = MAP.get(startPoint);
        UserModel userModel2 = MAP.get(endPoint);
        Session session = userModel.getSession();
        session.getAsyncRemote().sendText(message);
    }

    private void sendMessageToAll(String message) {}
}
