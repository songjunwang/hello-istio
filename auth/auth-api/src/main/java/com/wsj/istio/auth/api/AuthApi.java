package com.wsj.istio.auth.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 授权认证服务API
 *
 * @author WangSongJun
 */
@FeignClient(name = "auth", url = "${auth.url}")
public interface AuthApi {

    /**
     * 用户登录验证
     *
     * @param userId
     * @return
     */
    @PostMapping(value = "/user/login")
    String userLogin(String userId);

    @GetMapping("ping")
    String ping();
}
