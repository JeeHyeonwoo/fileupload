package com.hyeonu.fileupload.controller;

import com.hyeonu.fileupload.service.TusService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TusController {

    private final TusService tusService;

    // 업로드 페이지
    @GetMapping("/tus")
    public String tusUploadPage() {
        return "tus";
    }

    // 업로드 엔드포인트
    @ResponseBody
    @RequestMapping(value = {"/tus/upload", "/tus/upload/**"})
    public ResponseEntity<String> tusUpload(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.ok(tusService.tusUpload(request, response));
    }

}
