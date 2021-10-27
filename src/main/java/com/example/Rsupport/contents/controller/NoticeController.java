package com.example.Rsupport.contents.controller;

import com.example.Rsupport.contents.model.request.NoticeReq;
import com.example.Rsupport.contents.model.response.NoticeRes;
import com.example.Rsupport.contents.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


@Slf4j
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
    @PostMapping(value = "/notices", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveNotice(@RequestParam(name = "title", defaultValue = "공지사항 제목") String title,
                                        @RequestParam(name = "author", defaultValue = "작성자") String author,
                                        @RequestParam(name = "content", defaultValue = "공지사항 내용") String content,
                                        @RequestParam(name = "startDate", defaultValue = "2021-10-27")
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                        @RequestParam(name = "endDate", defaultValue = "2021-10-27")
                                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                                        @RequestPart(required = false) List<MultipartFile> files) throws Exception {

        NoticeReq req = NoticeReq.builder().title(title).author(author).content(content).startDate(startDate).endDate(endDate).build();
        log.info(String.valueOf(req));
        noticeService.saveNotice(req, files);
        return ResponseEntity.noContent().build();
    }
}


