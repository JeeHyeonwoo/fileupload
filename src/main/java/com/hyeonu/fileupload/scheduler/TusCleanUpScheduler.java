package com.hyeonu.fileupload.scheduler;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.desair.tus.server.TusFileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class TusCleanUpScheduler {

    private final TusFileUploadService tus;
    private final long cleanupDelay = 60 * 1000;

    @Scheduled(fixedDelay = cleanupDelay)
    public void cleanup() throws IOException {
        log.info("clean up");
        tus.cleanup();
    }
}