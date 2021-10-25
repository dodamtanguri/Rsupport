package com.example.Rsupport.contents.repository;

import com.example.Rsupport.contents.model.dto.NoticeImageDto;
import com.example.Rsupport.contents.model.entity.NoticeImage;
import org.springframework.data.repository.CrudRepository;

public interface NoticeImageRepository extends CrudRepository<NoticeImage,Long> {

    void save(NoticeImageDto noticeImage);
}
