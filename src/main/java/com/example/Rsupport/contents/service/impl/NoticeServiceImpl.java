package com.example.Rsupport.contents.service.impl;

import com.example.Rsupport.commons.handler.FileHandler;
import com.example.Rsupport.contents.model.entity.NoticeImage;
import com.example.Rsupport.contents.model.request.NoticeReq;
import com.example.Rsupport.contents.repository.NoticeImageRepository;
import com.example.Rsupport.contents.repository.NoticeRepository;
import com.example.Rsupport.contents.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeImageRepository noticeImageRepository;
    private final FileHandler fileHandler;

    @Transactional
    public void saveNotice(NoticeReq req, List<MultipartFile> files) throws Exception {
        Long noticeId = noticeRepository.save(req.toEntity()).getId();
        List<NoticeImage> images = fileHandler.parsingFile(noticeId, files);
        if (!images.isEmpty()) {
            noticeImageRepository.saveAll(images);
        }

    }
}
