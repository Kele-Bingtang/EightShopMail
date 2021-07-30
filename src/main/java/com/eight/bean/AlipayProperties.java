package com.eight.bean;

/**
 * 配置类，作用：把alipay.properties文件加载到类中
 */

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:alipay.properties"})
@ConfigurationProperties(prefix = "alipay")
public class AlipayProperties {
    private String app_id;
    private String privateKey;
    private String publicKey;
    private String notify_url;
    private String return_url;
    private String sign_type;
    private String charset;
    private String gatewayUrl;
    private String logPath;

    @Override
    public String toString() {
        return "AlipayProperties{" +
                "app_id='" + app_id + '\'' +
                ", privateKey='" + privateKey + '\'' +
                ", publicKey='" + publicKey + '\'' +
                ", notify_url='" + notify_url + '\'' +
                ", return_url='" + return_url + '\'' +
                ", sign_type='" + sign_type + '\'' +
                ", charset='" + charset + '\'' +
                ", gatewayUrl='" + gatewayUrl + '\'' +
                ", logPath='" + logPath + '\'' +
                '}';
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getNotify_url() {
        return notify_url;
    }

    public void setNotify_url(String notify_url) {
        this.notify_url = notify_url;
    }

    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getGatewayUrl() {
        return gatewayUrl;
    }

    public void setGatewayUrl(String gatewayUrl) {
        this.gatewayUrl = gatewayUrl;
    }

    public String getLogPath() {
        return logPath;
    }

    public void setLogPath(String logPath) {
        this.logPath = logPath;
    }


}

