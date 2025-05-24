package com.wsj.istio.auth.web;

import com.wsj.istio.account.api.AccountApi;
import com.wsj.istio.auth.api.AuthApi;
import com.wsj.istio.notification.api.NotificationApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 授权认证服务
 *
 * @author WangSongJun
 */
@RestController
@RequestMapping
public class AuthController implements AuthApi {
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Value("${info.app.version: v1.0}")
    private String appVersion;

    private final AccountApi accountApi;
    private final NotificationApi notificationApi;

    public AuthController(AccountApi accountApi, NotificationApi notificationApi) {
        this.accountApi = accountApi;
        this.notificationApi = notificationApi;
    }

    /**
     * 用户登录
     *
     * @param userId
     * @return
     */
    @Override
    @PostMapping(value = "/user/login")
    public String userLogin(String userId) {
        logger.info("用户 {} 登录，当前版本 {}", userId, appVersion);

        String userLogin = accountApi.userLogin(userId);


        String userLoginNotification = notificationApi.userLoginNotification(userId);

        return "Auth ("+appVersion+") -> "+userLogin+"\n Auth ("+appVersion+") -> "+userLoginNotification;
    }

    @Override
    @GetMapping("ping")
    public String ping() {
        logger.info("Ping");
        String accountPong = accountApi.ping();

        String notificationPong = notificationApi.ping();

        return "Auth ("+appVersion+") -> "+accountPong+" || Auth("+appVersion+") -> "+notificationPong;
    }
}
