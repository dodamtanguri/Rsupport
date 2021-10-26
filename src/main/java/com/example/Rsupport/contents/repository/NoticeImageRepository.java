package com.example.Rsupport.contents.repository;


import com.example.Rsupport.contents.model.entity.NoticeImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface NoticeImageRepository extends JpaRepository<NoticeImage, Long> {

}
