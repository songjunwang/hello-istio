package com.wsj.istio.account.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 账户服务API
 *
 * @author WangSongJun
 */
@FeignClient(name = "account", url = "${account.url}")
public interface AccountApi {

    /**
     * 用户登录
     *
     * 添加登录日志
     * 添加用户积分
     * 发送登录通知
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/user/login")
    String userLogin(String userId);

    @GetMapping("ping")
    String ping();
}
