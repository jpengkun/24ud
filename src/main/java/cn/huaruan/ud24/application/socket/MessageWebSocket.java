package cn.huaruan.ud24.application.socket;

import cn.huaruan.ud24.application.config.SpringConfigurator;
import cn.huaruan.ud24.service.MessageService;
import cn.huaruan.ud24.vo.MessageWithUserIds;
import cn.hutool.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

@ServerEndpoint(value = "/websocket/{userId}", configurator = SpringConfigurator.class)
@Component
public class MessageWebSocket {

    /**
     * concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
     */
    private static CopyOnWriteArraySet<MessageWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    private static Map<String, Session> sessionPool = new HashMap<>();

    @Autowired
    MessageService service;

    /**
     * 与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam(value = "userId") String userId) {
        this.session = session;
        webSocketSet.add(this);
        sessionPool.put(userId, session);
        Set<String> collect = sessionPool.keySet();
        System.out.println(userId + "[websocket消息]有新的连接，总数为:" + webSocketSet.size() + "分别是：" + collect.toString());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        Set<String> collect = sessionPool.keySet();
        System.out.println("[websocket消息]连接断开，总数为:" + webSocketSet.size() + "分别是：" + collect.toString());
    }

    @OnMessage
    public void onMessage(String message) {
        System.out.println("[websocket消息]收到客户端消息:" + message);
    }

    /**
     * 广播消息
     *
     * @param message
     */
    public void sendToAll(String message) {
        for (MessageWebSocket webSocket : webSocketSet) {
            System.out.println("[websocket消息]广播消息:" + message);
            try {
                webSocket.session.getAsyncRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 单点消息
     *
     * @param message
     */
    public void send(MessageWithUserIds message) {
        System.out.println("发送消息:" + message.getTitle());
        System.out.println("接收人id:" + message.getUserIds().toString());
        List<String> userIds = message.getUserIds();
        if (userIds != null) {
            try {
                userIds.forEach(userId -> {
                    Session session = sessionPool.get(userId);
                    if (session != null) {
                        session.getAsyncRemote().sendText(new JSONObject(message).toString());
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        service.addMessage(message);
    }

//    /**
//     * 多点消息
//     *
//     * @param message
//     */
//    public void sendToMany(List<String> userList, Message message) {
//        System.out.println("[websocket消息]多点消息:" + message);
//        try {
//            userList.forEach(userId -> {
//                service.addMessage(message);
//                Session session = sessionPool.get(userId);
//                if (session != null) {
//                    session.getAsyncRemote().sendText(new JSONObject(message).toString());
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


}
