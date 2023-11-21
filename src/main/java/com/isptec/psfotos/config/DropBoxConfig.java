package com.isptec.psfotos.config;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DropBoxConfig {

    @Value("${psfotos.dbx.appkey}")
    private String appKey;
    @Value("${psfotos.dbx.secret}")
    private String appSecret;
    @Value("${psfotos.dropbox.accesstoken}")
    private String dbxAccessToken;
//
//    @Value("")
//    private String appConfig;


    @Bean
    public DbxClientV2 dropBoxClientBean(){
        DbxRequestConfig config = DbxRequestConfig.newBuilder("psfotos").build();

//        config.
        return new DbxClientV2(config, dbxAccessToken);
    }


//    public
}
