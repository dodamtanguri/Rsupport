package com.example.Rsupport.commons.handler;

import com.example.Rsupport.contents.model.dto.NoticeImageDto;
import com.example.Rsupport.contents.model.entity.NoticeImage;
import com.example.Rsupport.contents.service.NoticeService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;
@Component
public class FileHandler {
    private final NoticeService noticeService;

    
    public FileHandler(NoticeService service) {
        this.noticeService = service;
    }


    public List<NoticeImage> parsingFile(long noticeId, List<MultipartFile> multipartFiles) throws Exception {
        List<NoticeImage> fileList = new ArrayList<>();

        if (!CollectionUtils.isEmpty(multipartFiles)) {
            for (MultipartFile multipartFile : multipartFiles) {
                String saveName = UUID.randomUUID().toString() + "_" + multipartFile.getOriginalFilename();
                //절대 경로 설정
                String absolutePath = new File("").getAbsolutePath() + File.separator + File.separator;
                //세부 경로 설정
                String path = "images" + File.separator + saveName;
                File file = new File(path);

                if (!file.exists()) {
                    boolean wasSuccessful = file.mkdirs();
                    if (!wasSuccessful) System.out.println("file : was not successful");
                }
                for (MultipartFile value : multipartFiles) {
                    NoticeImageDto noticeImage = NoticeImageDto.builder()
                            .noticeId(noticeId)
                            .saveFileName(saveName)
                            .originalFileName(value.getOriginalFilename())
                            .contentType(value.getContentType())
                            .build();

                    NoticeImage images = NoticeImage.builder()
                            .contentType(noticeImage.getContentType())
                            .originalFileName(noticeImage.getOriginalFileName())
                            .saveFileName(noticeImage.getSaveFileName()).build();
                    fileList.add(images);

                    file = new File(absolutePath + path + File.separator + saveName);
                    multipartFile.transferTo(file);

                    file.setWritable(true);
                    file.setReadable(true);

                }


            }


        }

        return fileList;
    }
}
