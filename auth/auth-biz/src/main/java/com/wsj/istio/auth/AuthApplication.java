package com.wsj.istio.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


/**
 * 授权认证服务
 *
 * @author WangSongJun
 */
@SpringBootApplication
@EnableFeignClients(basePackages = {
        "com.wsj.istio.account.api",
        "com.wsj.istio.notification.api"
})
public class AuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthApplication.class, args);
    }

}
