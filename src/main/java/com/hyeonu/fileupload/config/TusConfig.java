package com.hyeonu.fileupload.config;

import me.desair.tus.server.TusFileUploadService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TusConfig {
    private final String tusDataPath = "/Users/hyunu/tus/tmp";
    private final Long tusDataExpiration =  3600000L;
    private final String uploadUri = "/tus/upload";

    @Bean
    public TusFileUploadService tusFileUploadService() {
        return new TusFileUploadService()
                .withStoragePath(tusDataPath)
                .withDownloadFeature()
                .withUploadExpirationPeriod(tusDataExpiration)
                .withThreadLocalCache(true)
                .withUploadUri("/tus/upload");
    }
}
