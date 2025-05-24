package com.wsj.istio.notification.web;

import com.wsj.istio.notification.api.NotificationApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 通知服务
 *
 * @author WangSongJun
 */
@RestController
@RequestMapping
public class NotificationController implements NotificationApi {
    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Value("${info.app.version: v1.0}")
    private String appVersion;

    /**
     * 用户登录通知
     *
     * @param userId
     * @return
     */
    @Override
    @PostMapping(value = "/user/login")
    public String userLoginNotification(String userId) {
        logger.info("用户 {} 登录通知，当前版本 {}", userId, appVersion);
        return "Notification ("+appVersion+") User login notification received for ID: " + userId;
    }

    @Override
    @GetMapping("ping")
    public String ping() {
        logger.info("Ping");
        return "Notification ("+appVersion+") ";
    }
}
