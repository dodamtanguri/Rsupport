package com.example.Rsupport.contents.model.request;

import com.example.Rsupport.contents.model.entity.NoticeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NoticeReq {
    private String title;
    private String author;
    private String content;
    private LocalDate startDate;
    private LocalDate endDate;

    @Builder
    public NoticeReq(String title, String author, String content, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.author = author;
        this.content = content;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public NoticeEntity toEntity() {
        return NoticeEntity.builder()
                .title(title)
                .content(content)
                .author(author)
                .startDate(startDate)
                .endDate(endDate)
                .build();
    }

}
