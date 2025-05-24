package com.wsj.istio.account.web;

import com.wsj.istio.account.api.AccountApi;
import com.wsj.istio.notification.api.NotificationApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 账户服务
 *
 * @author WangSongJun
 */
@RestController
@RequestMapping
public class AccountController implements AccountApi {
    private static final Logger logger = LoggerFactory.getLogger(AccountController.class);

    @Value("${info.app.version: v1.0}")
    private String appVersion;

    private final NotificationApi notificationApi;

    public AccountController(NotificationApi notificationApi) {
        this.notificationApi = notificationApi;
    }


    /**
     * 用户登录通知
     *
     * @param userId
     * @return
     */
    @Override
    @PostMapping(value = "/user/login")
    public String userLogin(String userId) {
        logger.info("用户 {} 登录，当前版本 {}", userId, appVersion);

        logger.info("发送用户 {} 登录通知", userId);
        String loginNotification = notificationApi.userLoginNotification(userId);

        return "Account (" + appVersion + ") -> " + loginNotification;
    }

    @Override
    @GetMapping("ping")
    public String ping() {
        logger.info("Ping");

        String notificationPong = notificationApi.ping();
        return "Account (" + appVersion + ") -> " + notificationPong;
    }
}
