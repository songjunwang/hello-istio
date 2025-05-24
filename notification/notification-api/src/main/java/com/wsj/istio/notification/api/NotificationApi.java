package com.wsj.istio.notification.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 通知服务API
 *
 * @author WangSongJun
 */
@FeignClient(name = "notification", url = "${notification.url}")
public interface NotificationApi {

    /**
     * 用户登录通知
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/user/login")
    String userLoginNotification(String userId);

    @GetMapping("ping")
    String ping();
}
