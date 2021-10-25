package com.example.Rsupport.contents.controller;

import com.example.Rsupport.contents.model.request.NoticeReq;
import com.example.Rsupport.contents.model.response.NoticeRes;
import com.example.Rsupport.contents.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;
import javax.validation.Valid;

@Api(tags = "Rsupport 공지사항 관리 API")
@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {
    private final NoticeService noticeService;

    @ApiOperation(value = "회원가입")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    @PostMapping("/notices")
    public ResponseEntity<?> saveNotice(@Valid @RequestBody NoticeReq req, @RequestPart List<MultipartFile> files) throws Exception {
        noticeService.saveNotice(req, files);
        return ResponseEntity.noContent().build();
    }
}


