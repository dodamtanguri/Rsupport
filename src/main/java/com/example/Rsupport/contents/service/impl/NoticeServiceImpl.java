package com.example.Rsupport.contents.service.impl;

import com.example.Rsupport.contents.model.dto.NoticeImageDto;
import com.example.Rsupport.contents.model.entity.NoticeImage;
import com.example.Rsupport.contents.model.request.NoticeReq;
import com.example.Rsupport.contents.repository.NoticeImageRepository;
import com.example.Rsupport.contents.repository.NoticeRepository;
import com.example.Rsupport.contents.service.NoticeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final NoticeRepository noticeRepository;
    private final NoticeImageRepository noticeImageRepository;

    @Transactional
    public void saveNotice(NoticeReq req, List<MultipartFile> files) throws Exception {
        long noticeId = noticeRepository.save(req.toEntity()).getId();

        log.info(String.valueOf(noticeId));

        if (!CollectionUtils.isEmpty(files)) {
            for (MultipartFile multipartFile : files) {
                String saveName = UUID.randomUUID().toString() + multipartFile.getOriginalFilename();
                //절대 경로 설정
                String absolutePath = new File("").getAbsolutePath() + File.separator + File.separator;
                //세부 경로 설정
                String path = "images" + File.separator + saveName;
                File file = new File(path);

                if (!file.exists()) {
                    boolean wasSuccessful = file.mkdirs();
                    if (!wasSuccessful) System.out.println("file : was not successful");
                }
                for (MultipartFile value : files) {
                    NoticeImageDto noticeImage = NoticeImageDto.builder()
                            .noticeId(noticeId)
                            .saveFileName(saveName)
                            .originalFileName(value.getOriginalFilename())
                            .contentType(value.getContentType())
                            .build();
                    log.info(String.valueOf(noticeImage.getNoticeId()));
                    noticeImageRepository.save(noticeImage.toEntity());
                }
            }
        }

    }
}
