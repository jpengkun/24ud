package cn.huaruan.ud24.application.config;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import java.util.Collections;

public class SpringConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        String s = "*";
        response.getHeaders().put("Access-Control-Allow-Origin", Collections.singletonList(s));
    }

}
