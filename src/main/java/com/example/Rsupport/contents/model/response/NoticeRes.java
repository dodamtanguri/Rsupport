package com.example.Rsupport.contents.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NoticeRes {
    private long noticeId;
    private String title;
    private String author;

    @Builder
    public  NoticeRes(String title, String author, long noticeId) {
        this.title = title;
        this.author = author;
        this.noticeId = noticeId;
    }

}
