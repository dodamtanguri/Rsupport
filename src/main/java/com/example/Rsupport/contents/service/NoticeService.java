package com.example.Rsupport.contents.service;

import com.example.Rsupport.contents.model.request.NoticeReq;
import com.example.Rsupport.contents.model.response.NoticeRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface NoticeService {
    void saveNotice(NoticeReq req, List<MultipartFile> files) throws Exception;
}
